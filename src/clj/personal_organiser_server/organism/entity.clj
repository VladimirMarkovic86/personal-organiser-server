(ns personal-organiser-server.organism.entity
  (:require [language-lib.core :refer [get-label]]
            [personal-organiser-middle.organism.entity :as pomoe]
            [personal-organiser-middle.grocery.entity :as pomge])
  (:import [java.text SimpleDateFormat]))

(defn format-birthday-field
  "Formats birthday field into human readable format"
  [raw-birthday
   chosen-language]
  (when (and raw-birthday
             (instance?
               java.util.Date
               raw-birthday))
    (let [sdf (SimpleDateFormat.
              "d MMM yyyy")]
      (.format
        sdf
        raw-birthday))
   ))

(defn format-gender-field
  "Formats gender field"
  [raw-gender
   chosen-language]
  (when (and raw-gender
             (string?
               raw-gender))
    (let [gender-a (atom raw-gender)]
      (when (= raw-gender
               pomoe/gender-male)
        (reset!
          gender-a
          (get-label
            1050
            chosen-language))
       )
      (when (= raw-gender
               pomoe/gender-female)
        (reset!
          gender-a
          (get-label
            1051
            chosen-language))
       )
      @gender-a))
 )

(defn format-diet-field
  "Formats gender field"
  [raw-diet
   chosen-language]
  (when (and raw-diet
             (string?
               raw-diet))
    (let [diet-a (atom raw-diet)]
      (when (= raw-diet
               pomge/diet-vegetarian)
        (reset!
          diet-a
          (get-label
            1044
            chosen-language))
       )
      (when (= raw-diet
               pomge/diet-not-vegetarian)
        (reset!
          diet-a
          (get-label
            1042
            chosen-language))
       )
      @diet-a))
 )

(defn format-activity-field
  "Formats gender field"
  [raw-activity
   chosen-language]
  (when (and raw-activity
             (vector?
               raw-activity))
    (let [raw-activity (first
                         raw-activity)
          activity-a (atom raw-activity)]
      (when (= raw-activity
               pomoe/activity-mainly-sitting)
        (reset!
          activity-a
          (get-label
            1045
            chosen-language))
       )
      (when (= raw-activity
               pomoe/activity-easy-physical-labor)
        (reset!
          activity-a
          (get-label
            1046
            chosen-language))
       )
      (when (= raw-activity
               pomoe/activity-medium-physical-labor)
        (reset!
          activity-a
          (get-label
            1047
            chosen-language))
       )
      (when (= raw-activity
               pomoe/activity-hard-physical-labor)
        (reset!
          activity-a
          (get-label
            1048
            chosen-language))
       )
      (when (= raw-activity
               pomoe/activity-very-hard-physical-labor)
        (reset!
          activity-a
          (get-label
            1049
            chosen-language))
       )
      @activity-a))
 )

(defn reports
  "Returns reports projection"
  [& [chosen-language]]
  {:entity-label (get-label
                   1026
                   chosen-language)
   :projection [:first-name
                :last-name
                ;:email
                :height
                :weight
                :birthday
                :gender
                :diet
                :activity
                ]
   :qsort {:first-name 1}
   :rows pomoe/rows
   :labels {:first-name (get-label
                          1001
                          chosen-language)
            :last-name (get-label
                         1002
                         chosen-language)
            :email (get-label
                     14
                     chosen-language)
            :height (get-label
                      1003
                      chosen-language)
            :weight (get-label
                      1004
                      chosen-language)
            :birthday (get-label
                        1005
                        chosen-language)
            :gender (get-label
                      1006
                      chosen-language)
            :diet (get-label
                    1007
                    chosen-language)
            :activity (get-label
                        1008
                        chosen-language)
            }
   :columns {:first-name {:width "20"
                          :header-background-color "lightblue"
                          :header-text-color "white"}
             :last-name {:width "20"
                         :header-background-color "lightblue"
                         :header-text-color "white"}
             :email {:width "15"
                     :header-background-color "lightblue"
                     :header-text-color "white"
                     :column-alignment "C"}
             :height {:width "10"
                      :header-background-color "lightblue"
                      :header-text-color "white"
                      :column-alignment "R"}
             :weight {:width "10"
                      :header-background-color "lightblue"
                      :header-text-color "white"
                      :column-alignment "R"}
             :birthday {:width "25"
                        :header-background-color "lightblue"
                        :header-text-color "white"
                        :data-format-fn format-birthday-field
                        :column-alignment "C"}
             :gender {:width "15"
                      :header-background-color "lightblue"
                      :header-text-color "white"
                      :data-format-fn format-gender-field
                      :column-alignment "C"}
             :diet {:width "15"
                    :header-background-color "lightblue"
                    :header-text-color "white"
                    :data-format-fn format-diet-field
                    :column-alignment "C"}
             :activity {:width "15"
                        :header-background-color "lightblue"
                        :header-text-color "white"
                        :data-format-fn format-activity-field
                        :column-alignment "C"}
             }
   })

