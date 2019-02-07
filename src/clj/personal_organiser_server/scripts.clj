(ns personal-organiser-server.scripts
  (:require [mongo-lib.core :as mon]
            [common-middle.collection-names :refer [db-updates-cname]]
            [common-server.scripts :as css]
            [personal-organiser-server.scripts.language :as possl]
            [personal-organiser-server.scripts.role :as possr]
            [personal-organiser-server.scripts.user :as possu]
            [personal-organiser-server.scripts.grocery :as possg]
            [personal-organiser-server.scripts.meal :as possm]
            [personal-organiser-server.scripts.organism :as posso]))

(defn initialize-db
  "Initialize database"
  []
  (css/initialize-db)
  (possl/insert-labels)
  (possr/insert-roles)
  (possu/update-users)
  (possg/insert-groceries)
  (possm/insert-meals)
  (posso/insert-organisms)
  (mon/mongodb-insert-one
    db-updates-cname
    {:initialized true
     :date (java.util.Date.)})
 )

(defn initialize-db-if-needed
  "Check if database exists and initialize it if it doesn't"
  []
  (try
    (when-not (mon/mongodb-exists
                db-updates-cname
                {:initialized true})
      (initialize-db))
    (catch Exception e
      (println e))
   ))

