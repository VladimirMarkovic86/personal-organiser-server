(ns personal-organiser-server.meal.entity
  (:require [language-lib.core :refer [get-label]]
            [personal-organiser-middle.meal.entity :as pomme]
            [common-server.preferences :as prf]))

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

(defn reports
  "Returns reports projection"
  [request
   & [chosen-language]]
  (prf/set-preferences
    request)
  {:entity-label (get-label
                   1017
                   chosen-language)
   :projection [;:mname
                :label-code
                :calories-sum
                :proteins-sum
                :fats-sum
                :carbonhydrates-sum
                ;:description
                ;:image
                ;:mtype
                ;:part-of-meal
                ;:ingredients
                ]
   :qsort {:gname 1}
   :rows (int
           (pomme/calculate-rows))
   :table-rows (int
                 @pomme/table-rows-a)
   :card-columns (int
                   @pomme/card-columns-a)
   :labels {:mname (get-label
                     1010
                     chosen-language)
            :label-code (get-label
                          1010
                          chosen-language)
            :calories-sum (get-label
                            1018
                            chosen-language)
            :proteins-sum (get-label
                            1019
                            chosen-language)
            :fats-sum (get-label
                        1020
                        chosen-language)
            :carbonhydrates-sum (get-label
                                  1021
                                  chosen-language)
            :description (get-label
                           1015
                           chosen-language)
            :image (get-label
                     1022
                     chosen-language)
            :mtype (get-label
                     1023
                     chosen-language)
            :part-of-meal (get-label
                            1024
                            chosen-language)
            :ingredients (get-label
                           1027
                           chosen-language)
            }
   :columns {:mname {:width "30"
                     :header-background-color "lightblue"
                     :header-text-color "white"}
             :label-code {:width "30"
                          :header-background-color "lightblue"
                          :header-text-color "white"
                          :data-format-fn format-label-code-field}
             :calories-sum {:width "15"
                            :header-background-color "lightblue"
                            :header-text-color "white"
                            :column-alignment "R"}
             :proteins-sum {:width "15"
                            :header-background-color "lightblue"
                            :header-text-color "white"
                            :column-alignment "R"}
             :fats-sum {:width "15"
                        :header-background-color "lightblue"
                        :header-text-color "white"
                        :column-alignment "R"}
             :carbonhydrates-sum {:width "25"
                                  :header-background-color "lightblue"
                                  :header-text-color "white"
                                  :column-alignment "R"}
             :description {:width "15"
                           :header-background-color "lightblue"
                           :header-text-color "white"}
             :image {:width "30"
                     :header-background-color "lightblue"
                     :header-text-color "white"
                     :column-alignment "C"}
             :mtype {:width "15"
                     :header-background-color "lightblue"
                     :header-text-color "white"
                     :column-alignment "C"}
             :part-of-meal {:width "15"
                            :header-background-color "lightblue"
                            :header-text-color "white"
                            :column-alignment "C"}
             :ingredients {:width "15"
                           :header-background-color "lightblue"
                           :header-text-color "white"
                           :column-alignment "R"}
             }
   })

