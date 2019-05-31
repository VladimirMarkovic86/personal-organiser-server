(ns personal-organiser-server.core
  (:gen-class)
  (:require [session-lib.core :as ssn]
            [server-lib.core :as srvr]
            [mongo-lib.core :as mon]
            [personal-organiser-server.config :as config]
            [personal-organiser-server.scripts :as scripts]
            [personal-organiser-middle.request-urls :as prurls]
            [personal-organiser-middle.functionalities :as pomfns]
            [common-server.core :as rt]
            [ajax-lib.http.entity-header :as eh]
            [ajax-lib.http.mime-type :as mt]
            [ajax-lib.http.status-code :as stc]
            [ajax-lib.http.request-method :as rm]
            [audit-lib.core :refer [audit]]
            [personal-organiser-middle.collection-names :refer [grocery-cname
                                                                meal-cname
                                                                organism-cname]]
            [personal-organiser-lib.core :as pol]))

(defn get-meals-with-groceries
  "Returns meals from database with data of groceries"
  []
  (let [meals (mon/mongodb-find
                meal-cname
                {}
                {:_id 0
                 :mname 1
                 :label-code 1
                 :mtype 1
                 :fats-sum 1
                 :carbonhydrates-sum 1
                 :proteins-sum 1
                 :calories-sum 1
                 :ingredients 1
                 :diet 1})
        meals-with-groceries (atom [])]
    (doseq [meal meals]
      (let [ingredients (:ingredients meal)
            changed-ingredients (atom [])]
        (doseq [[_id
                 grams
                 quantity] ingredients]
          (let [{calories :calories
                 proteins :proteins
                 fats :fats
                 carbonhydrates :carbonhydrates
                 label-code :label-code
                 gname :gname} (mon/mongodb-find-by-id
                                 grocery-cname
                                 _id)
                ingredient-weight (* grams
                                     quantity)
                adjusted-calories (* (/ ingredient-weight
                                        100)
                                     calories)
                adjusted-proteins (* (/ ingredient-weight
                                        100)
                                     proteins)
                adjusted-fats (* (/ ingredient-weight
                                    100)
                                 fats)
                adjusted-carbonhydrates (* (/ ingredient-weight
                                              100)
                                           carbonhydrates)]
            (swap!
              changed-ingredients
              conj
              {:gname gname
               :label-code label-code
               :calories adjusted-calories
               :proteins adjusted-proteins
               :fats adjusted-fats
               :carbonhydrates adjusted-carbonhydrates
               :grams ingredient-weight}))
         )
        (swap!
          meals-with-groceries
          conj
          (assoc
            meal
            :ingredients
            @changed-ingredients))
       ))
    @meals-with-groceries))

(defn calculate-meal-recommendations
  "Calculates meal recommendations for particular organism"
  [request]
  (let [{organism-id :organism-id
         breakfast-calories-share :breakfast-calories-share
         lunch-calories-share :lunch-calories-share
         dinner-calories-share :dinner-calories-share} (:body
                                                         request)
        organism (mon/mongodb-find-by-id
                   organism-cname
                   organism-id)
        meals (get-meals-with-groceries)
        meals-recommendations (pol/calculate
                                organism
                                meals
                                breakfast-calories-share
                                lunch-calories-share
                                dinner-calories-share)]
    {:status (stc/ok)
     :headers {(eh/content-type) (mt/text-clojurescript)}
     :body {:status "success"
            :data meals-recommendations}}))

(def logged-in-routing-set
  (atom
    #{{:method rm/POST
       :uri prurls/calculate-meal-recommendations-url
       :authorization pomfns/meal-recommendation
       :action calculate-meal-recommendations}}))

(def logged-out-routing-set
  (atom
    #{}))

(defn routing
  "Custom routing function"
  [request]
  (rt/add-new-routes
    @logged-in-routing-set
    @logged-out-routing-set)
  (let [response (rt/routing
                   request)]
    (when @config/audit-action-a
      (audit
        request
        response))
    response))

(defn start-server
  "Start server"
  []
  (try
    (let [port (config/define-port)
          access-control-map (config/build-access-control-map)
          certificates-map (config/build-certificates-map)]
      (config/set-thread-pool-size)
      (config/set-audit)
      (srvr/start-server
        routing
        access-control-map
        port
        certificates-map))
    (mon/mongodb-connect
      config/db-uri
      config/db-name)
    (scripts/initialize-db-if-needed)
    (ssn/create-indexes)
    (config/add-custom-entities-to-entities-map)
    (config/set-report-paths)
    (config/read-sign-up-roles)
    (config/setup-e-mail-account)
    (config/setup-e-mail-templates-path)
    (catch Exception e
      (println (.getMessage e))
     ))
 )

(defn stop-server
  "Stop server"
  []
  (try
    (srvr/stop-server)
    (mon/mongodb-disconnect)
    (catch Exception e
      (println (.getMessage e))
     ))
 )

(defn unset-restart-server
  "Stop server, unset server atom to nil
   reload project, start new server instance"
  []
  (stop-server)
  (use 'personal-organiser-server.core :reload)
  (start-server))

(defn -main [& args]
  (start-server))

