(ns personal-organiser-server.core
 (:use [compojure.core :only [defroutes GET POST DELETE OPTIONS]]
       [clojure.data   :only [diff]])
 (:require
      [compojure.handler                              :as chandler]
      [compojure.route                                :as route]
      [ring.adapter.jetty                             :refer [run-jetty]]
      [personal-organiser-server.ring.middleware.cors :refer [wrap-cors]]
      [personal-organiser-server.http.entity-header   :as eh]
      [personal-organiser-server.utils                :as utils]
      [personal-organiser-server.mongo                :as mon]
      [personal-organiser-server.http.response-header :as rsh]
      [personal-organiser-server.http.mime-type       :as mt]
      [personal-organiser-server.http.status-code     :as stc]))

(defn hello-world
  "Function for testing success"
  [param]
  {:status  (stc/ok)
   :headers {(eh/content-type) (mt/text-plain)}
   :body    (str "Hello World " param)})

(defn hello-world-error
  "Function for testing error"
  [param]
  {:status  (stc/bad-request)
   :headers {(eh/content-type) (mt/text-plain)}
   :body    (str "Hello World " param)})
   
(defn what-is-my-ip
  "Return ip address of this server"
  [remote-addr]
  {:status  (stc/ok)
   :headers {(eh/content-type) (mt/text-plain)}
   :body    remote-addr})

(defn random-uuid
  "Generate uuid"
  []
  (def uuid (.toString (java.util.UUID/randomUUID))
   )
  uuid)

(def users-map
  [{:email "markovic.vladimir86@gmail.com"
    :password "123"}
   {:email "123"
    :password "123"}])

(defn get-pass-for-email
  "Get password for supplied email"
  [itr
   entity-map
   result]
  (if (< itr (count users-map))
   (let [db-user        (nth users-map itr)
         same-email     (= (:email db-user) (:email entity-map))
         same-password  (= (:password db-user) (:password entity-map))]
        (if same-email
            (if same-password
                (swap! result conj {:status   "success"
                                    :email    "success"
                                    :password "success"})
                (swap! result conj {:email "success"}))
            (recur (inc itr) entity-map result))
    )
   @result))

(defn login-authentication
  "Login authentication"
  [entity-body]
  (let [result (get-pass-for-email 0
                                   entity-body 
                                   (atom {:status   "error"
                                          :email    "error"
                                          :password "error"}))]
   (if (= (:status result)
          "success")
       {:status  (stc/ok)
        :headers {(eh/content-type) (mt/text-plain)
                  (rsh/set-cookie)   (str "session=" (random-uuid) "; "
                                           "Expires=Wed, 30 Aug 2019 00:00:00 GMT; "
                                           "Path=/"
                                           ;"Domain=localhost:1612; "
                                           ;"Secure; "
                                           ;"HttpOnly"
                                           )}
        :body    (str result)}
       {:status  (stc/unauthorized)
        :headers {(eh/content-type) (mt/text-plain)}
        :body    (str result)})
   ))

; Expires=Wed, 30 Aug 2019 00:00:00 GMT
; Max-age=5000
; Domain=localhost:1612
; Path=/
; Secure
; HttpOnly
; SameSite=Strict
; SameSite=Lax

(defn am-i-logged-in
  "Check if user is logged in"
  [session-uuid]
  (if (= session-uuid
         uuid)
      {:status  (stc/ok)
       :headers {(eh/content-type) (mt/text-plain)}}
      {:status  (stc/unauthorized)
       :headers {(eh/content-type) (mt/text-plain)}}))

(defn get-cookie-by-name
  "Reurn cookie value by cookie name"
  [cookies
   cookie-name
   cookie-index]
  (if (< cookie-index (count cookies))
   (let [[cname value] (cookies cookie-index)]
    (if (= cookie-name
           cname)
     (:value value)
     (recur cookies cookie-name (inc cookie-index))
     ))
   nil))


(defn get-cookie
  "Read cookie from request"
  [request
   cookie-name]
  (get-cookie-by-name (into [] (:cookies request))
                      cookie-name
                      0))

(defn get-entities
  "Prepare data for table"
  [request-body]
  (if (empty? (:entity-filter request-body))
   (let [current-page     (:current-page request-body)
         rows             (:rows request-body)
         count-entities   (mon/coll-count
                           (:entity-type request-body)
                           (:entity-filter request-body))
         number-of-pages  (utils/round-up count-entities rows)
         current-page     (if (= current-page number-of-pages)
                           (dec current-page)
                           current-page)
         entity-type    (:entity-type request-body)
         entity-filter  (:entity-filter request-body)
         projection     (:projection request-body)
         qsort          (:qsort request-body)
         final-result   (atom [])
         db-result      (mon/find-by-filter-projection-sort-and-limit
                         entity-type
                         entity-filter
                         projection
                         qsort
                         rows
                         (* current-page
                            rows))]
    (if (not= -1 current-page)
     (doseq [single-result db-result]
      (let [_id  (:_id single-result)
            _id-as-str  (str _id)
            ekeys  (keys single-result)
            entity-as-vector  (atom [])]
       (doseq [ekey ekeys]
        (if (= ekey :_id)
         (swap! entity-as-vector conj _id-as-str)
         (swap! entity-as-vector conj (ekey single-result))
         ))
       (swap! final-result conj @entity-as-vector))
      )
     nil)
    {:status  (stc/ok)
     :headers {(eh/content-type) (mt/text-plain)}
     :body    (str {:status  "success"
                    :data       @final-result
                    :pagination {:current-page     current-page
                                 :rows             rows
                                 :total-row-count  count-entities}
                    })})
   {:status  (stc/bad-request)
    :headers {(eh/content-type) (mt/text-plain)}
    :body    (str {:status  "error"
                   :error-message "404 Bad request"})}))

(defn get-entity
  "Prepare requested grocery for response"
  [request-body]
  (let [entity  (mon/find-by-id (:entity-type request-body)
                                (:_id (:entity-filter request-body))
                 )
        entity  (assoc entity :_id (str (:_id entity))
                 )]
   (if entity
    {:status (stc/ok)
     :headers {(eh/content-type) (mt/text-plain)}
     :body   (str {:status  "success"
                   :data  entity})}
    {:status (stc/not-found)
     :headers {(eh/content-type) (mt/text-plain)}
     :body   (str {:status  "error"
                   :error-message "There is no grocery, for given criteria."})}))
  )

(defn update-entity
  "Update grocery"
  [request-body]
  (try
   (mon/update-by-id (:entity-type request-body)
                     (:_id request-body)
                     (:entity request-body))
   {:status  (stc/ok)
    :headers {(eh/content-type) (mt/text-plain)}
    :body    (str {:status "success"})}
   (catch Exception ex
    (println (.getMessage ex))
    {:status  (stc/internal-server-error)
     :headers {(eh/content-type) (mt/text-plain)}
     :body    (str {:status "error"})}))
  )

(defn insert-entity
  "Update grocery"
  [request-body]
  (try
   (mon/insert-and-return (:entity-type request-body)
                          (:entity request-body))
   {:status  (stc/ok)
    :headers {(eh/content-type) (mt/text-plain)}
    :body    (str {:status "success"})}
   (catch Exception ex
    (println (.getMessage ex))
    {:status  (stc/internal-server-error)
     :headers {(eh/content-type) (mt/text-plain)}
     :body    (str {:status "error"})}))
  )

(defn delete-entity
  "Delete entity"
  [request-body]
  (try
   (mon/remove-by-id (:entity-type request-body)
                     (:_id (:entity-filter request-body))
    )
   {:status  (stc/ok)
    :headers {(eh/content-type) (mt/text-plain)}
    :body    (str {:status "success"})}
   (catch Exception ex
    (println (.getMessage ex))
    {:status  (stc/internal-server-error)
     :headers {(eh/content-type) (mt/text-plain)}
     :body    (str {:status "error"})}))
  )

(defn not-found
  "Requested action not found"
  []
  {:status  (stc/not-found)
   :headers {(eh/content-type) (mt/text-plain)}
   :body    (str {:status  "error"
                  :error-message "404 not found"})})

(defn parse-body
  "Read entity-body from request, convert from string to clojure data"
  [request]
  (read-string (slurp (:body request))
   ))

(defroutes app-routes
  (GET "/what-is-my-ip"
       request
       (println request)
       (what-is-my-ip (:remote-addr request))
    )
  (GET "/hello-world"
       request
       (println request)
       (hello-world "hello"))
  (OPTIONS "/index1"
           request
           (println request)
           (hello-world "index1"))
  (POST "/index1"
        request
        (println request)
        (hello-world "index1"))
  (OPTIONS "/index2"
           request
           (println request)
           (hello-world-error "index2"))
  (POST "/index2"
        request
        (println request)
        (hello-world-error "index2"))
  (OPTIONS "/login"
           request
           (println request)
           (hello-world "login"))
  (POST "/login"
        request
        (println request)
        (login-authentication (parse-body request))
   )
  (POST "/am-i-logged-in"
        request
        (println request)
        (am-i-logged-in (get-cookie request "session"))
   )
  (POST "/get-entities"
        request
        (println request)
        (get-entities (parse-body request))
   )
  (POST "/get-entity"
        request
        (println request)
        (get-entity (parse-body request))
   )
  (POST "/update-entity"
        request
        (println request)
        (update-entity (parse-body request))
   )
  (POST "/insert-entity"
        request
        (println request)
        (insert-entity (parse-body request))
   )
  (DELETE "/delete-entity"
        request
        (println request)
        (delete-entity (parse-body request))
   )
  (route/resources "/")
  (route/not-found (not-found))
; (POST "*"
;  request
;  (println request)
;  (hello-world "hi"))
  )

(def handler (-> (chandler/site
                  (wrap-cors
                   app-routes
                   :access-control-allow-origin    [#"https://personal-organiser:8443"
                                                    #"http://personal-organiser:8445"
                                                    #"https://127.0.0.1:8443"
                                                    #"http://127.0.0.1:8445"
                                                    #"http://localhost:3449"]
                   :access-control-allow-methods   [:get :post :delete]
                   ;:access-control-allow-credentials  "true"
                   ))
               ))

(defonce server (atom nil))

(defn start-server
  "Start server"
  []
  (if @server
      (let []
       (println "Server instance exists")
       (try
        (.start @server)
        (mon/connect-mongo)
        (catch Exception ex
               (println (.getMessage ex))
         ))
       )
      (let []
       (println "Server instance does not exist")
       (try
        (reset! server (run-jetty handler { :port 1612 :join? false}))
        (mon/connect-mongo)
        (catch Exception ex
               (println ex))
        ))
   ))

(defn stop-server
  "Stop server"
  []
  (if @server
   (let []
    (println "Server stopping")
    (try
     (.stop @server)
     (mon/disconnect-mongo)
     (println "Server stopped")
     (catch Exception ex
            (println ex))
     ))
   (println "Server not initialized"))
  )

(defn atom-server-unset
  "Unset server from handler"
  []
  (reset! server nil))

(defn unset-restart-server
  "Stop server, unset server atom to nil
   reload project, start new server instance"
  []
  (stop-server)
  (atom-server-unset)
  (use 'personal-organiser-server.core :reload)
  (start-server))

(defn -main [& args]
  (start-server))

