(ns personal-organiser-server.mongo
  "Namespace for manipulating data from mongo database"
  (:require [monger.core        :as mg]
            [monger.credentials :as mcr]
            [monger.collection  :as mcoll]
            [monger.query        :as q]
            [monger.operators   :refer :all])
  (:import org.bson.types.ObjectId))

(def personal-organiser-db "personal-organiser-db")

(def organism-coll "organism")

(def training-coll "training")

(def grocery-coll "grocery")

(def meal-coll "meal")

(def market-place-coll "market_place")

(def conn (atom nil))

(def db (atom nil))

(defn connect-mongo
  "Connect to mongo db"
  []
  (let [admin-db "admin"
        username "admin"
        password "passw0rd"
        cred (mcr/create username
                         admin-db
                         password)
        host "127.0.0.1"
        port 27017]
    (swap! conn
           (fn [conn-input]
            (mg/connect-with-credentials host
                                         port
                                         cred))
         )
    (swap! db
           (fn [db-input]
            (mg/get-db @conn
                       personal-organiser-db))
     ))
  )

(defn disconnect-mongo
  "Disconnect from mongo db"
  []
  (mg/disconnect @conn))

(defn find-by-filter
  "Find documents from collection by filter"
  [collection-name
   entity-filter]
  (mcoll/find-maps
   @db
   collection-name
   entity-filter))

(defn find-one
  "Find document from collection by filter"
  [collection-name
   entity-filter]
  (mcoll/find-one-as-map
   @db
   collection-name
   entity-filter))

(defn find-by-id
  "Find documents from collection by id"
  [collection-name
   id]
  (mcoll/find-map-by-id
   @db
   collection-name
   (ObjectId. id))
  )

(defn find-all-from-list
  "Find documents from collection by id list"
  [collection-name
   document-id-list]
  (def return-docs [])
  (doseq [document-with-id document-id-list]
    (let [document-from-db (find-by-id collection-name (:id document-with-id))]
      (def return-docs
           (conj return-docs
                 (conj document-from-db
                       document-with-id))
       ))
   )
  return-docs)

(defn insert-and-return
  "Insert document into collection and return it"
  [collection-name
   insert-document]
  (mcoll/insert-and-return
   @db
   collection-name
   insert-document))

(defn update-by-id
  "Update document into collection by id"
  [collection-name
   id
   update-document]
  (mcoll/update-by-id
   @db
   collection-name
   (ObjectId. id)
   {$set update-document}))

(defn remove-by-id
  "Remove document from collection by id"
  [collection-name
   id]
  (mcoll/remove-by-id
   @db
   collection-name
   (ObjectId. id))
  )

(defn find-by-filter-projection-sort-and-limit
  "Find entities by filter, projection, sort and limit"
  [coll-name
   entity-filter
   entity-fields
   sort-array-map
   result-limit
   skip]
  (vec (q/with-collection
        @db
        coll-name
        (q/find entity-filter)
        (q/fields entity-fields)
        (q/sort sort-array-map)
        (q/limit result-limit)
        (q/skip skip))
   ))

(defn coll-count
  "Count records in collection for particular filter"
  [coll-name
   entity-filter]
  (mcoll/count
   @db
   coll-name
   entity-filter))

