(ns personal-organiser-server.preferences
  (:require [personal-organiser-middle.grocery.entity :as pomge]
            [personal-organiser-middle.meal.entity :as pomme]
            [personal-organiser-middle.organism.entity :as pomoe]))

(defn set-specific-preferences-fn
  "Sets preferences on server side"
  [specific-map]
  (let [{{{table-rows-g :table-rows
           card-columns-g :card-columns} :grocery-entity
          {table-rows-m :table-rows
           card-columns-m :card-columns} :meal-entity
          {table-rows-o :table-rows
           card-columns-o :card-columns} :organism-entity} :display} specific-map]
    (reset!
      pomge/table-rows-a
      (or table-rows-g
          10))
    (reset!
      pomge/card-columns-a
      (or card-columns-g
          0))
    (reset!
      pomme/table-rows-a
      (or table-rows-m
          10))
    (reset!
      pomme/card-columns-a
      (or card-columns-m
          0))
    (reset!
      pomoe/table-rows-a
      (or table-rows-o
          10))
    (reset!
      pomoe/card-columns-a
      (or card-columns-o
          0))
   ))

