(ns personal-organiser-server.scripts.role
  (:require [mongo-lib.core :as mon]
            [common-middle.collection-names :refer [role-cname]]
            [personal-organiser-middle.functionalities :as pomfns]
            [personal-organiser-middle.role-names :refer [grocery-admin-rname
                                                          grocery-mod-rname
                                                          meal-admin-rname
                                                          meal-mod-rname
                                                          organism-admin-rname
                                                          organism-mod-rname
                                                          meal-recommendation-rname]]))

(defn insert-roles
  "Inserts roles"
  []
  (mon/mongodb-insert-many
    role-cname
    [{:role-name grocery-admin-rname
      :functionalities [pomfns/grocery-create
                        pomfns/grocery-read
                        pomfns/grocery-update
                        pomfns/grocery-delete]}
     {:role-name grocery-mod-rname
      :functionalities [pomfns/grocery-read
                        pomfns/grocery-update]}
     {:role-name meal-admin-rname
      :functionalities [pomfns/meal-create
                        pomfns/meal-read
                        pomfns/meal-update
                        pomfns/meal-delete]}
     {:role-name meal-mod-rname
      :functionalities [pomfns/meal-read
                        pomfns/meal-update]}
     {:role-name organism-admin-rname
      :functionalities [pomfns/organism-create
                        pomfns/organism-read
                        pomfns/organism-update
                        pomfns/organism-delete]}
     {:role-name organism-mod-rname
      :functionalities [pomfns/organism-read
                        pomfns/organism-update]}
     {:role-name meal-recommendation-rname
      :functionalities [pomfns/meal-recommendation]}
     ]))

