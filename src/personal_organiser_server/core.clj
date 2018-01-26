(ns personal-organiser-server.core
 (:use [compojure.core
        :only [defroutes GET POST OPTIONS]])
 (:require [compojure.handler
             :as chandler]
      [compojure.route
        :as route]
      [ring.adapter.jetty
        :refer [run-jetty]]
      [personal-organiser-server.ring.middleware.cors
        :refer [wrap-cors]]
      [personal-organiser-server.http.entity-header
        :as enth]))

(defn hello-world [param]
  {:status  200
   :headers {(enth/content-type) "text/plain"}
   :body    (str "Hello World " param)})

(defn hello-world-error [param]
  {:status  404
   :headers {(enth/content-type) "text/plain"}
   :body    (str "Hello World " param)})
   
(defn what-is-my-ip [remote-addr]
  {:status  200
   :headers {(enth/content-type) "text/plain"}
   :body    remote-addr})

(defn login-authentication
  "Login authentication"
  [entity-body]
  (if (and (= (:email entity-body)
              "123")
           (= (:password entity-body)
              "123"))
       {:status  200
        :headers {(enth/content-type) "text/plain"}
        :body    "1"}
       {:status  200
        :headers {(enth/content-type) "text/plain"}
        :body    "2"}))

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
  (OPTIONS "/clojure/index1"
           request
           (println request)
           (hello-world "index1"))
  (POST "/clojure/index1"
        request
        (println request)
        (hello-world "index1"))
  (OPTIONS "/clojure/index2"
           request
           (println request)
           (hello-world-error "index2"))
  (POST "/clojure/index2"
        request
        (println request)
        (hello-world-error "index2"))
  (OPTIONS "/clojure/login"
           request
           (println request)
           (hello-world "login"))
  (POST "/clojure/login"
        request
        (println request)
        (login-authentication (read-string (slurp (:body request))
                               ))
   )
  (route/resources "/")
  (route/not-found (hello-world "hi"))
; (POST "*"
;  request
;  (println request)
;  (hello-world "hi")
;  )
  )

(def handler (-> (chandler/site
                  (wrap-cors
                   app-routes
                   :access-control-allow-origin    #"http://localhost:8443"
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

(defn -main [& args]
  (start-server))

