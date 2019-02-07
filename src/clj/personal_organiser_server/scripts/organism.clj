(ns personal-organiser-server.scripts.organism
  (:require [mongo-lib.core :as mon]
            [personal-organiser-middle.collection-names :refer [organism-cname]]))

(defn insert-organisms
  "Inserts organisms"
  []
  (mon/mongodb-insert-many
    organism-cname
    [{:email "123@123"
      :last-name "Markovic"
      :birthday (let [calendar (java.util.Calendar/getInstance)]
                  (.set
                    calendar
                    1986
                    9
                    16)
                  (.getTime
                    calendar))
      :first-name "Vladimir"
      :activity [ "mainly_sitting" ]
      :weight 89
      :gender "male"
      :height 182
      :diet "not_vegetarian"}
     ]))

