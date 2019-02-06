(ns personal-organiser-server.scripts.user
  (:require [mongo-lib.core :as mon]
            [common-middle.collection-names :refer [user-cname
                                                    role-cname]]
            [personal-organiser-middle.role-names :refer [grocery-admin-rname
                                                          meal-admin-rname
                                                          organism-admin-rname
                                                          meal-recommendation-rname]]))

(defn update-users
  "Updates users"
  []
  (let [grocery-admin-id (:_id
                           (mon/mongodb-find-one
                             role-cname
                             {:role-name grocery-admin-rname}))
        meal-admin-id (:_id
                        (mon/mongodb-find-one
                          role-cname
                          {:role-name meal-admin-rname}))
        organism-admin-id (:_id
                            (mon/mongodb-find-one
                              role-cname
                              {:role-name organism-admin-rname}))
        meal-recommendation-id (:_id
                                 (mon/mongodb-find-one
                                   role-cname
                                   {:role-name meal-recommendation-rname}))
        personal-organiser-roles [grocery-admin-id
                                  meal-admin-id
                                  organism-admin-id
                                  meal-recommendation-id]]
    (mon/mongodb-update-one
      user-cname
      {:username "admin"}
      {:$addToSet
        {:roles
          {:$each personal-organiser-roles}}
       })
    (mon/mongodb-update-one
      user-cname
      {:username "guest"}
      {:$addToSet
        {:roles
          {:$each personal-organiser-roles}}
       }))
 )

