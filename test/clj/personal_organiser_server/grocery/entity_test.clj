(ns personal-organiser-server.grocery.entity-test
  (:require [clojure.test :refer :all]
            [personal-organiser-server.grocery.entity :refer :all]
            [mongo-lib.core :as mon])
  (:import [java.text SimpleDateFormat]
           [java.util Calendar
                      Date
                      TimeZone]))

(def db-uri
     (or (System/getenv "MONGODB_URI")
         (System/getenv "PROD_MONGODB")
         "mongodb://admin:passw0rd@127.0.0.1:27017/admin"))

(def db-name
     "test-db")

(defn create-db
  "Create database for testing"
  []
  (mon/mongodb-connect
    db-uri
    db-name)
  (mon/mongodb-insert-many
    "language"
    [{ :code 1044
       :english "Vegetarian"
       :serbian "Вегетаријанска" }
     { :code 1042
       :english "Not vegetarian"
       :serbian "Не вегетаријанска" }]))

(defn destroy-db
  "Destroy testing database"
  []
  (mon/mongodb-drop-database
    db-name)
  (mon/mongodb-disconnect))

(deftest test-format-label-code-field
  (testing "Test format label code field"
    
    (create-db)
    
    (let [raw-label-code nil
          chosen-language nil
          result (format-label-code-field
                   raw-label-code
                   chosen-language)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [raw-label-code 1044
          chosen-language nil
          result (format-label-code-field
                   raw-label-code
                   chosen-language)]
      
      (is
        (not
          (nil?
            result))
       )
      
      (is
        (= result
           "Vegetarian")
       )
      
     )
    
    (let [raw-label-code 1042
          chosen-language "serbian"
          result (format-label-code-field
                   raw-label-code
                   chosen-language)]
      
      (is
        (not
          (nil?
            result))
       )
      
      (is
        (= result
           "Не вегетаријанска")
       )
      
     )
    
    (destroy-db)
    
   ))

(deftest test-format-diet-field
  (testing "Test format diet field"
    
    (create-db)
    
    (let [raw-diet nil
          selected-language nil
          result (format-diet-field
                   raw-diet
                   selected-language)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [raw-diet "test"
          selected-language nil
          result (format-diet-field
                   raw-diet
                   selected-language)]
      
      (is
        (= result
           "test")
       )
      
     )
    
    (let [raw-diet "vegetarian"
          selected-language nil
          result (format-diet-field
                   raw-diet
                   selected-language)]
      
      (is
        (= result
           "Vegetarian")
       )
      
     )
    
    (let [raw-diet "not_vegetarian"
          selected-language "serbian"
          result (format-diet-field
                   raw-diet
                   selected-language)]
      
      (is
        (= result
           "Не вегетаријанска")
       )
      
     )
    
    (destroy-db)
    
   ))


