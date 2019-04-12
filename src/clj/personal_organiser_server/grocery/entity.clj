(ns personal-organiser-server.grocery.entity
  (:require [language-lib.core :refer [get-label]]
            [personal-organiser-middle.grocery.entity :as pomge]))

(defn format-label-code-field
  "Formats label code field"
  [raw-label-code
   chosen-language]
  (when (and raw-label-code
             (number?
               raw-label-code))
    (get-label
      raw-label-code
      chosen-language))
 )

(defn format-diet-field
  "Formats diet field"
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

(defn reports
  "Returns reports projection"
  [& [chosen-language]]
  {:entity-label (get-label
                   1009
                   chosen-language)
   :projection [;:gname
                :label-code
                :calories
                :proteins
                :fats
                :carbonhydrates
                ;:description
                :diet
                ;:group
                ]
   :qsort {:gname 1}
   :rows pomge/rows
   :labels {:gname (get-label
                     1010
                     chosen-language)
            :label-code (get-label
                          1010
                          chosen-language)
            :calories (get-label
                        1011
                        chosen-language)
            :proteins (get-label
                        1012
                        chosen-language)
            :fats (get-label
                    1013
                    chosen-language)
            :carbonhydrates (get-label
                              1014
                              chosen-language)
            :description (get-label
                           1015
                           chosen-language)
            :diet (get-label
                    1007
                    chosen-language)
            :group (get-label
                     1052
                     chosen-language)
            }
   :columns {:gname {:width "30"
                     :header-background-color "lightblue"
                     :header-text-color "white"}
             :label-code {:width "30"
                          :header-background-color "lightblue"
                          :header-text-color "white"
                          :data-format-fn format-label-code-field}
             :calories {:width "15"
                        :header-background-color "lightblue"
                        :header-text-color "white"
                        :column-alignment "R"}
             :proteins {:width "15"
                        :header-background-color "lightblue"
                        :header-text-color "white"
                        :column-alignment "R"}
             :fats {:width "15"
                    :header-background-color "lightblue"
                    :header-text-color "white"
                    :column-alignment "R"}
             :carbonhydrates {:width "25"
                              :header-background-color "lightblue"
                              :header-text-color "white"
                              :column-alignment "R"}
             :description {:width "15"
                           :header-background-color "lightblue"
                           :header-text-color "white"}
             :diet {:width "30"
                    :header-background-color "lightblue"
                    :header-text-color "white"
                    :data-format-fn format-diet-field
                    :column-alignment "C"}
             :group {:width "15"
                     :header-background-color "lightblue"
                     :header-text-color "white"
                     :column-alignment "C"}
             }
   })

