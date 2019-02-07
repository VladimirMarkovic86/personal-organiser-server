(ns personal-organiser-server.scripts.meal
  (:require [mongo-lib.core :as mon]
            [personal-organiser-middle.collection-names :refer [meal-cname
                                                                grocery-cname]]))

(defn insert-meals
  "Inserts meals"
  []
  (let [green-peas-id (:_id
                        (mon/mongodb-find-one
                          grocery-cname
                          {:gname "Грашак зелени"}))
        carrot-id (:_id
                    (mon/mongodb-find-one
                      grocery-cname
                      {:gname "Шаргарепа"}))
        potato-id (:_id
                    (mon/mongodb-find-one
                      grocery-cname
                      {:gname "Кромпир свеж"}))
        onion-id (:_id
                   (mon/mongodb-find-one
                     grocery-cname
                     {:gname "Лук црни"}))
        oil-id (:_id
                 (mon/mongodb-find-one
                   grocery-cname
                   {:gname "Уље"}))
        wheat-flour-id (:_id
                         (mon/mongodb-find-one
                           grocery-cname
                           {:gname "Пшенично брашно (тип 600)"}))
        pork-meat-id (:_id
                       (mon/mongodb-find-one
                         grocery-cname
                         {:gname "Месо свеже свињско масно средње"}))
        beef-meat-id (:_id
                       (mon/mongodb-find-one
                         grocery-cname
                         {:gname "Месо свеже говеђе масно средње"}))
        chicken-meat-id (:_id
                          (mon/mongodb-find-one
                            grocery-cname
                            {:gname "Живина Пиле"}))
        cow-milk-id (:_id
                      (mon/mongodb-find-one
                        grocery-cname
                        {:gname "Млеко кравље"}))
        corn-flakes-id (:_id
                         (mon/mongodb-find-one
                           grocery-cname
                           {:gname "Кукурузне пахуљице"}))
        sugar-id (:_id
                   (mon/mongodb-find-one
                     grocery-cname
                     {:gname "Шећер"}))
        bake-rolls-garlic-id (:_id
                               (mon/mongodb-find-one
                                 grocery-cname
                                 {:gname "Двопек са белим луком"}))
        bake-rolls-pizza-id (:_id
                              (mon/mongodb-find-one
                                grocery-cname
                                {:gname "Двопек са укусом пице"}))
        bake-rolls-bacon-id (:_id
                              (mon/mongodb-find-one
                                grocery-cname
                                {:gname "Двопек са укусом сланине"}))
        ]
    (mon/mongodb-insert-many
      meal-cname
      [{:description "Test meal"
        :mname "Грашак са свињским месом"
        :label-code 1263
        :mtype ["lunch"]
        :calories-sum 4299.2
        :proteins-sum 138.7
        :fats-sum 353.53
        :carbonhydrates-sum 111.75
        :part-of-meal ["all_in_one"]
        :ingredients [[green-peas-id
                       400
                       1]
                      [carrot-id
                       100
                       1]
                      [potato-id
                       100
                       1]
                      [oil-id
                       135
                       1]
                      [wheat-flour-id
                       15
                       1]
                      [onion-id
                       50
                       1]
                      [pork-meat-id
                       700
                       1]]
        :image "https://personal-organiser-client.herokuapp.com/"
        :diet "not_vegetarian"}
       {:description "Test meal"
        :mname "Грашак са говеђим месом"
        :label-code 1264
        :mtype ["lunch"]
        :calories-sum 2934.2
        :proteins-sum 169.5
        :fats-sum 191.13
        :carbonhydrates-sum 111.75
        :part-of-meal ["all_in_one"]
        :ingredients [[green-peas-id
                       400
                       1]
                      [carrot-id
                       100
                       1]
                      [potato-id
                       100
                       1]
                      [oil-id
                       135
                       1]
                      [wheat-flour-id
                       15
                       1]
                      [onion-id
                       50
                       1]
                      [beef-meat-id
                       700
                       1]]
        :image "https://personal-organiser-client.herokuapp.com/"
        :diet "not_vegetarian"}
       {:description "Test meal"
        :mname "Грашак са пилетином"
        :label-code 1265
        :mtype ["lunch"]
        :calories-sum 2906.2
        :proteins-sum 178.6
        :fats-sum 186.93
        :carbonhydrates-sum 108.95
        :part-of-meal ["all_in_one"]
        :ingredients [[green-peas-id
                       400
                       1]
                      [carrot-id
                       100
                       1]
                      [potato-id
                       100
                       1]
                      [oil-id
                       135
                       1]
                      [wheat-flour-id
                       15
                       1]
                      [onion-id
                       50
                       1]
                      [chicken-meat-id
                       700
                       1]]
        :image "https://personal-organiser-client.herokuapp.com/"
        :diet "not_vegetarian"}
       {:description "Test meal"
        :mname "Млеко са кукурузним пахуљицама"
        :label-code 1266
        :mtype ["breakfast"]
        :calories-sum 362.5
        :proteins-sum 9.06
        :fats-sum 5.7
        :carbonhydrates-sum 66.57
        :part-of-meal ["all_in_one"]
        :ingredients [[cow-milk-id
                       150
                       1]
                      [corn-flakes-id
                       60
                       1]
                      [sugar-id
                       10
                       1]]
        :image "https://personal-organiser-client.herokuapp.com/"
        :diet "vegetarian"}
       {:description "Test meal"
        :mname "Двопек са укусом белог лука"
        :label-code 1257
        :mtype ["dinner"]
        :calories-sum 715.2
        :proteins-sum 22.4
        :fats-sum 24
        :carbonhydrates-sum 99.2
        :part-of-meal ["all_in_one"]
        :ingredients [[bake-rolls-garlic-id
                       160
                       1]]
        :image "https://personal-organiser-client.herokuapp.com/"
        :diet "vegetarian"}
       {:description "Test meal"
        :mname "Двопек са укусом пице"
        :label-code 1258
        :mtype ["dinner"]
        :calories-sum 734.4
        :proteins-sum 20.8
        :fats-sum 24
        :carbonhydrates-sum 105.6
        :part-of-meal ["all_in_one"]
        :ingredients [[bake-rolls-pizza-id
                       160
                       1]]
        :image "https://personal-organiser-client.herokuapp.com/"
        :diet "vegetarian"}
       {:description "Test meal"
        :mname "Двопек са укусом сланине"
        :label-code 1259
        :mtype ["dinner"]
        :calories-sum 740.8
        :proteins-sum 20.8
        :fats-sum 24
        :carbonhydrates-sum 107.2
        :part-of-meal ["all_in_one"]
        :ingredients [[bake-rolls-bacon-id
                       160
                       1]]
        :image "https://personal-organiser-client.herokuapp.com/"
        :diet "not_vegetarian"}
       ]))
 )

