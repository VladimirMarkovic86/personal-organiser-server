(ns personal-organiser-server.organism.entity-test
  (:require [clojure.test :refer :all]
            [personal-organiser-server.organism.entity :refer :all]
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
    [{ :code 1050
       :english "Male"
       :serbian "Мушки" }
     { :code 1051
       :english "Female"
       :serbian "Женски" }
     { :code 1044
       :english "Vegetarian"
       :serbian "Вегетаријанска" }
     { :code 1042
       :english "Not vegetarian"
       :serbian "Не вегетаријанска" }
     { :code 1045
       :english "Mainly sitting"
       :serbian "Углавном седеће" }
     { :code 1046
       :english "Easy physical labor"
       :serbian "Лак физички рад" }
     { :code 1047
       :english "Medium physical labor"
       :serbian "Средњи физички рад" }
     { :code 1048
       :english "Hard physical labor"
       :serbian "Тежак физички рад" }
     { :code 1049
       :english "Very hard physical labor"
       :serbian "Веома тежак физички рад" }
     ]))

(defn destroy-db
  "Destroy testing database"
  []
  (mon/mongodb-drop-database
    db-name)
  (mon/mongodb-disconnect))

(deftest test-format-birthday-field
  (testing "Test format birthday field"
    
    (let [raw-birthday nil
          chosen-language nil
          result (format-birthday-field
                   raw-birthday
                   chosen-language)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [date (Calendar/getInstance)
          void (.set
                 date
                 Calendar/DATE
                 11)
          void (.set
                 date
                 Calendar/MONTH
                 10)
          void (.set
                 date
                 Calendar/YEAR
                 2013)
          void (.setTimeZone
                 date
                 (TimeZone/getDefault))
          raw-birthday (Date.
                         (.getTimeInMillis
                           date))
          chosen-language nil
          result (format-birthday-field
                   raw-birthday
                   chosen-language)]
      
      (is
        (not
          (nil?
            result))
       )
      
      (is
        (string?
          result)
       )
      
      (is
        (= result
           "11 Nov 2013")
       )
      
     )
    
   ))

(deftest test-format-gender-field
  (testing "Test format gender field"
    
    (create-db)
    
    (let [raw-gender nil
          chosen-language nil
          result (format-gender-field
                   raw-gender
                   chosen-language)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [raw-gender "unknown"
          chosen-language nil
          result (format-gender-field
                   raw-gender
                   chosen-language)]
      
      (is
        (= result
           "unknown")
       )
      
     )
    
    (let [raw-gender "male"
          chosen-language nil
          result (format-gender-field
                   raw-gender
                   chosen-language)]
      
      (is
        (= result
           "Male")
       )
      
     )
    
    (let [raw-gender "female"
          chosen-language "serbian"
          result (format-gender-field
                   raw-gender
                   chosen-language)]
      
      (is
        (= result
           "Женски")
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
    
    (let [raw-diet "unknown"
          selected-language nil
          result (format-diet-field
                   raw-diet
                   selected-language)]
      
      (is
        (= result
           "unknown")
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

(deftest test-format-activity-field
  (testing "Test format activity field"
    
    (create-db)
    
    (let [raw-activity nil
          selected-language nil
          result (format-activity-field
                   raw-activity
                   selected-language)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [raw-activity ["unknown"]
          selected-language nil
          result (format-activity-field
                   raw-activity
                   selected-language)]
      
      (is
        (= result
           "unknown")
       )
      
     )
    
    (let [raw-activity ["mainly_sitting"]
          selected-language nil
          result (format-activity-field
                   raw-activity
                   selected-language)]
      
      (is
        (= result
           "Mainly sitting")
       )
      
     )
    
    (let [raw-activity ["easy_physical_labor"]
          selected-language nil
          result (format-activity-field
                   raw-activity
                   selected-language)]
      
      (is
        (= result
           "Easy physical labor")
       )
      
     )
    
    (let [raw-activity ["medium_physical_labor"]
          selected-language nil
          result (format-activity-field
                   raw-activity
                   selected-language)]
      
      (is
        (= result
           "Medium physical labor")
       )
      
     )
    
    (let [raw-activity ["hard_physical_labor"]
          selected-language "serbian"
          result (format-activity-field
                   raw-activity
                   selected-language)]
      
      (is
        (= result
           "Тежак физички рад")
       )
      
     )
    
    (let [raw-activity ["very_hard_physical_labor"]
          selected-language "serbian"
          result (format-activity-field
                   raw-activity
                   selected-language)]
      
      (is
        (= result
           "Веома тежак физички рад")
       )
      
     )
    
    (destroy-db)
    
   ))

