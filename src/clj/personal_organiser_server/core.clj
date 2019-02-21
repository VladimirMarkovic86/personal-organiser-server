(ns personal-organiser-server.core
  (:gen-class)
  (:require [session-lib.core :as ssn]
            [server-lib.core :as srvr]
            [mongo-lib.core :as mon]
            [personal-organiser-server.scripts :as scripts]
            [personal-organiser-middle.request-urls :as prurls]
            [personal-organiser-middle.functionalities :as pomfns]
            [common-server.core :as rt]
            [ajax-lib.http.response-header :as rsh]
            [ajax-lib.http.entity-header :as eh]
            [ajax-lib.http.mime-type :as mt]
            [ajax-lib.http.status-code :as stc]
            [utils-lib.core :refer [parse-body]]
            [audit-lib.core :refer [audit]]
            [personal-organiser-middle.collection-names :refer [grocery-cname
                                                                meal-cname
                                                                organism-cname]]
            [personal-organiser-lib.core :as pol]))

(def db-uri
     (or (System/getenv "MONGODB_URI")
         (System/getenv "PROD_MONGODB")
         "mongodb://admin:passw0rd@127.0.0.1:27017/admin"))

(def db-name
     "personal-organiser-db")

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
  [{organism-id :organism-id
    breakfast-calories-share :breakfast-calories-share
    lunch-calories-share :lunch-calories-share
    dinner-calories-share :dinner-calories-share}]
  (let [organism (mon/mongodb-find-by-id
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
     :headers {(eh/content-type) (mt/text-plain)}
     :body (str
             {:status "success"
              :data meals-recommendations})})
 )

(defn response-routing-fn
  "Custom routing function"
  [request]
  (let [{request-uri :request-uri
         request-method :request-method} request]
    (cond
      (= request-method
         "POST")
        (cond
          (= request-uri
             prurls/calculate-meal-recommendations-url)
            (calculate-meal-recommendations
              (parse-body
                request))
          :else
            nil)
      :else
        nil))
 )

(defn allow-action-routing-fn
  "Check if action is allowed for logged in user"
  [request]
  (let [allowed-functionalities (rt/get-allowed-actions
                                  request)
        {request-uri :request-uri
         request-method :request-method} request]
    (cond
      (= request-method
         "POST")
        (cond
          (= request-uri
             prurls/calculate-meal-recommendations-url)
            (contains?
              allowed-functionalities
              pomfns/meal-recommendation)
          :else
            false)
      :else
        false))
 )

(defn routing
  "Custom routing function"
  [request]
  (let [response (rt/routing
                   request
                   response-routing-fn
                   allow-action-routing-fn)]
    (audit
      request
      response)
    response))

(defn start-server
  "Start server"
  []
  (try
    (let [port (System/getenv "PORT")
          port (if port
                 (read-string
                   port)
                 1601)
          access-control-allow-origin #{"https://personal-organiser:8443"
                                        "https://personal-organiser:1611"
                                        "http://personal-organiser:1611"
                                        "https://personal-organiser:1601"
                                        "http://personal-organiser:1601"
                                        "https://192.168.1.86:1611"
                                        "http://192.168.1.86:1611"
                                        "https://192.168.1.86:1601"
                                        "http://192.168.1.86:1601"
                                        "http://personal-organiser:8445"}
          access-control-allow-origin (if (System/getenv "CLIENT_ORIGIN")
                                        (conj
                                          access-control-allow-origin
                                          (System/getenv "CLIENT_ORIGIN"))
                                        access-control-allow-origin)
          access-control-allow-origin (if (System/getenv "SERVER_ORIGIN")
                                        (conj
                                          access-control-allow-origin
                                          (System/getenv "SERVER_ORIGIN"))
                                        access-control-allow-origin)
          access-control-map {(rsh/access-control-allow-origin) access-control-allow-origin
                              (rsh/access-control-allow-methods) "OPTIONS, GET, POST, DELETE, PUT"
                              (rsh/access-control-allow-credentials) true}
          certificates {:keystore-file-path
                         "certificate/personal_organiser_server.jks"
                        :keystore-password
                         "ultras12"}
          certificates (when-not (System/getenv "CERTIFICATES")
                         certificates)
          thread-pool-size (System/getenv "THREAD_POOL_SIZE")]
      (when thread-pool-size
        (reset!
          srvr/thread-pool-size
          (read-string
            thread-pool-size))
       )
      (srvr/start-server
        routing
        access-control-map
        port
        certificates))
    (mon/mongodb-connect
      db-uri
      db-name)
    (scripts/initialize-db-if-needed)
    (ssn/create-indexes)
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

