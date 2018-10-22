(ns personal-organiser-server.core
  (:gen-class)
  (:require [session-lib.core :as ssn]
            [server-lib.core :as srvr]
            [mongo-lib.core :as mon]
            [personal-organiser-server.scripts :as scripts]
            [common-server.core :as rt]
            [ajax-lib.http.response-header :as rsh]))

(def db-uri
     (or (System/getenv "PROD_MONGODB")
         "mongodb://admin:passw0rd@127.0.0.1:27017/admin"))

(def db-name
     "personal-organiser-db")

(defn routing
  "Custom routing function"
  [request]
  (rt/routing
    request))

(defn start-server
  "Start server"
  []
  (try
    (let [port (System/getenv "PORT")
          port (if port
                 (read-string
                   port)
                 1601)]
      (srvr/start-server
        routing
        {(rsh/access-control-allow-origin) #{"https://personal-organiser:8443"
                                             "https://personal-organiser:1611"
                                             "http://personal-organiser:1611"
                                             "http://personal-organiser:8445"}
         (rsh/access-control-allow-methods) "OPTIONS, GET, POST, DELETE, PUT"
         (rsh/access-control-allow-credentials) true}
        port
        {:keystore-file-path
          "certificate/personal_organiser_server.jks"
         :keystore-password
          "ultras12"}))
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

