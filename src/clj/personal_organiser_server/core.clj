(ns personal-organiser-server.core
  (:gen-class)
  (:require [session-lib.core :as ssn]
            [server-lib.core :as srvr]
            [mongo-lib.core :as mon]
            [personal-organiser-server.scripts :as scripts]
            [common-server.core :as rt]
            [ajax-lib.http.response-header :as rsh]))

(def db-uri
     (or (System/getenv "MONGODB_URI")
         (System/getenv "PROD_MONGODB")
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
                 1601)
          access-control-allow-origin #{"https://personal-organiser:8443"
                                        "https://personal-organiser:1611"
                                        "http://personal-organiser:1611"
                                        "https://personal-organiser:1601"
                                        "http://personal-organiser:1601"
                                        "http://personal-organiser:8445"}
          access-control-allow-origin (if (System/getenv "CLIENT_ORIGIN")
                                        (conj
                                          access-control-allow-origin
                                          (System/getenv "CLIENT_ORIGIN"))
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

