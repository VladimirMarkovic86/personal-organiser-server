(ns personal-organiser-server.core
 (:use [compojure.core :only [defroutes GET POST OPTIONS]]
       [clojure.data   :only [diff]])
 (:require
      [compojure.handler                              :as chandler]
      [compojure.route                                :as route]
      [ring.adapter.jetty                             :refer [run-jetty]]
      [personal-organiser-server.ring.middleware.cors :refer [wrap-cors]]
      [personal-organiser-server.http.entity-header   :as eh]
      [personal-organiser-server.http.response-header :as rsh]
      [personal-organiser-server.http.mime-type       :as mt]
      [personal-organiser-server.http.status-code     :as stc]))

(defn hello-world
  ""
  [param]
  {:status  (stc/ok)
   :headers {(eh/content-type) (mt/text-plain)}
   :body    (str "Hello World " param)})

(defn hello-world-error
  ""
  [param]
  {:status  (stc/bad-request)
   :headers {(eh/content-type) (mt/text-plain)}
   :body    (str "Hello World " param)})
   
(defn what-is-my-ip [remote-addr]
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
                (swap! result conj {:status "success"})
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
           name)
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

(def grocery-header
 [;{:gname          {:content "Name"}}
  {:calories       {:content "Calories"}}
  {:fats           {:content "Fats"}}
  ;{:proteins       {:content "Proteins"}}
  {:carbonhydrates {:content "Carbonhydrates"}}
  {:water          {:content "Water"}}
  {:description    {:content "Description"}}
  {:origin         {:content "Origin"}}
;  {:option         {:colspan 2
;                    :content "Option"}}
   ])

(def groceries
  (atom [{:gname          "Boranija"
          :calories       1
          :fats           2
          :proteins       3
          :carbonhydrates 4
          :water          5
          :description    "boranija description"
          :origin         "Vegetarian"}
         {:gname          "Pasulj"
          :calories       1
          :fats           2
          :proteins       3
          :carbonhydrates 4
          :water          5
          :origin         "Vegetarian"}
         {:gname          "Krompir"
          :calories       1
          :fats           2
          :proteins       3
          :carbonhydrates 4
          :water          5
          :origin         "Vegetarian"}
         {:gname          "Psenica"
          :calories       1
          :fats           2
          :proteins       3
          :carbonhydrates 4
          :water          5
          :origin         "Vegetarian"}]))

(defn grocery-table-data
  ""
  [query-map]
  (if (empty? (:search query-map))
   {:status  (stc/ok)
    :headers {(eh/content-type) (mt/text-plain)}
    :body    (str {:grocery-header   grocery-header
                   :groceries        @groceries})}
   {:status  (stc/bad-request)
    :headers {(eh/content-type) (mt/text-plain)}
    :body    (str {:error-message "404 Bad request"})}))

(defn get-grocery
  ""
  [grocery-name
   groceries-index]
  (if (< groceries-index (count @groceries))
   (let [db-grocery (@groceries groceries-index)]
    (if (= grocery-name (:gname db-grocery))
     db-grocery
     (recur grocery-name (inc groceries-index))
     ))
   nil))

(defn get-grocery-by-name
  ""
  [grocery-query]
  (let [grocery (get-grocery (:gname (:search grocery-query)) 0)]
   (if grocery
    {:status (stc/ok)
     :headers {(eh/content-type) (mt/text-plain)}
     :body   (str {:status  "success"
                   :grocery grocery})}
    {:status (stc/not-found)
     :headers {(eh/content-type) (mt/text-plain)}
     :body   (str {:status  "error"
                   :grocery nil})}))
  )

(defn insert-grocery
  ""
  [grocery-map]
  (swap! groceries conj grocery-map))

(defn parse-body
  ""
  [body]
  (read-string (slurp body))
  )

(defn conj-grocery
  ""
  [groceries-param
   grocery]
  (let [count-before-remove (count groceries-param)
        removed-grocery     (into []
                                  (remove (fn [db-grocery]
                                              (= (:gname db-grocery)
                                                 (:gname grocery))
                                           )
                                   @groceries))
        count-after-remove  (count removed-grocery)
        element-removed     (not= count-before-remove count-after-remove)]
   (if element-removed
    (conj removed-grocery grocery)
    @groceries))
  )

(defn update-grocery
  ""
  [grocery]
  (try
   (swap! groceries conj-grocery grocery)
   {:status  (stc/ok)
    :headers {(eh/content-type) (mt/text-plain)}
    :body    (str {:status "success"})}
   (catch Exception ex
    (println (.getMessage ex))
    {:status  (stc/internal-server-error)
     :headers {(eh/content-type) (mt/text-plain)}
     :body    (str {:status "error"})}))
  )

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
        (login-authentication (parse-body (:body request))
         ))
  (POST "/am-i-logged-in"
        request
        (println request)
        (am-i-logged-in (get-cookie request "session"))
   )
  (POST "/grocery-table-data"
        request
        (println request)
        (grocery-table-data (parse-body (:body request))
         ))
  (POST "/insert-grocery"
        request
        (println request)
        (insert-grocery (parse-body (:body request))
         ))
  (POST "/get-grocery-by-name"
        request
        (println request)
        (get-grocery-by-name (parse-body (:body request))
         ))
  (POST "/update-grocery"
        request
        (println request)
        (update-grocery (parse-body (:body request))
         ))
  (route/resources "/")
  (route/not-found (hello-world "hi"))
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
                   :access-control-allow-methods   [:get :post]
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
        (catch Exception ex
               (println (.getMessage ex))
         ))
       )
      (let []
       (println "Server instance does not exist")
       (try
        (reset! server (run-jetty handler { :port 1612 :join? false}))
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

