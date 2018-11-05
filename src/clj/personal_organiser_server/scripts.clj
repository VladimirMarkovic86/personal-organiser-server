(ns personal-organiser-server.scripts
  (:require [mongo-lib.core :as mon]
            [utils-lib.core :as utils]
            [common-middle.collection-names :refer [db-updates-cname
                                                    language-cname
                                                    role-cname
                                                    user-cname
                                                    preferences-cname]]
            [common-middle.role-names :refer [user-admin-rname
                                              user-mod-rname
                                              language-admin-rname
                                              language-mod-rname
                                              role-admin-rname
                                              role-mod-rname]]
            [personal-organiser-middle.role-names :refer [grocery-admin-rname
                                                          grocery-mod-rname
                                                          meal-admin-rname
                                                          meal-mod-rname
                                                          organism-admin-rname
                                                          organism-mod-rname]]
            [common-middle.functionalities :as fns]
            [personal-organiser-middle.functionalities :as pomfns]))

(defn initialize-db
  "Initialize database"
  []
  (mon/mongodb-insert-many
    language-cname
    [{ :code 1, :english "Save", :serbian "Сачувај" }
     { :code 2, :english "Log out", :serbian "Одјави се" }
     { :code 3, :english "Home", :serbian "Почетна" }
     { :code 4, :english "Create", :serbian "Креирај" }
     { :code 5, :english "Show all", :serbian "Прикажи све" }
     { :code 6, :english "Details", :serbian "Детаљи" }
     { :code 7, :english "Edit", :serbian "Измени" }
     { :code 8, :english "Delete", :serbian "Обриши" }
     { :code 9, :english "Actions", :serbian "Акције" }
     { :code 10, :english "Insert", :serbian "Упиши" }
     { :code 11, :english "Update", :serbian "Ажурирај" }
     { :code 12, :english "Cancel", :serbian "Откажи" }
     { :code 13, :english "Search", :serbian "Претрага" }
     { :code 14, :english "E-mail", :serbian "Е-пошта" }
     { :code 15, :english "Password", :serbian "Лозинка" }
     { :code 16, :english "Remember me", :serbian "Упамти ме" }
     { :code 17, :english "Log in", :serbian "Пријави се" }
     { :code 18, :english "Sign up", :serbian "Направи налог" }
     { :code 19, :english "Username", :serbian "Корисничко име" }
     { :code 20, :english "Confirm password", :serbian "Потврди лозинку" }
     { :code 21, :english "User", :serbian "Корисник" }
     { :code 22, :english "Role", :serbian "Улога" }
     { :code 23, :english "Language", :serbian "Језик" }
     { :code 24, :english "Label code", :serbian "Код лабеле" }
     { :code 25, :english "English", :serbian "Енглески" }
     { :code 26, :english "Serbian", :serbian "Српски" }
     { :code 27, :english "Functionality", :serbian "Функционалност" }
     { :code 28, :english "Role name", :serbian "Назив улоге" }
     { :code 29, :english "Functionalities", :serbian "Функционалности" }
     { :code 30, :english "Roles", :serbian "Улоге" }
     { :code 1005, :english "Birthday", :serbian "Датум рођења" }
     { :code 1006, :english "Gender", :serbian "Пол" }
     { :code 1007, :english "Diet", :serbian "Исхрана" }
     { :code 1008, :english "Activity", :serbian "Активности" }
     { :code 1009, :english "Grocery", :serbian "Намирница" }
     { :code 1010, :english "Name", :serbian "Назив" }
     { :code 1011, :english "Calories", :serbian "Калорије" }
     { :code 1012, :english "Proteins", :serbian "Протеини" }
     { :code 1013, :english "Fats", :serbian "Масти" }
     { :code 1014, :english "Carbonhydrates", :serbian "Угљени хидрати" }
     { :code 1015, :english "Description", :serbian "Опис" }
     { :code 1016, :english "Origin", :serbian "Порекло" }
     { :code 1017, :english "Meal", :serbian "Оброк" }
     { :code 1018, :english "Calories sum", :serbian "Укупно калорија" }
     { :code 1019, :english "Proteins sum", :serbian "Укупно протеина" }
     { :code 1020, :english "Fats sum", :serbian "Укупно масти" }
     { :code 1021, :english "Carbonhydrates sum", :serbian "Укупно угљених хидрата" }
     { :code 1022, :english "Image", :serbian "Слика" }
     { :code 1023, :english "Type of meal", :serbian "Врста оброка" }
     { :code 1024, :english "Portion", :serbian "Порција" }
     { :code 1025, :english "Ingrediants", :serbian "Састојци" }
     { :code 1026, :english "Organism", :serbian "Организам" }
     { :code 1001, :english "First name", :serbian "Име" }
     { :code 1002, :english "Last name", :serbian "Презиме" }
     { :code 1003, :english "Height", :serbian "Висина" }
     { :code 1004, :english "Weight", :serbian "Тежина" }
     { :code 1027, :english "Grams", :serbian "Грама" }
     { :code 1028, :english "Quantity", :serbian "Квантитет" }
     { :code 31, :english "No entities", :serbian "Нема ентитета" }])
  (mon/mongodb-insert-many
    role-cname
    [{:role-name user-admin-rname
      :functionalities [fns/user-create
                        fns/user-read
                        fns/user-update
                        fns/user-delete]}
     {:role-name user-mod-rname
      :functionalities [fns/user-read
                        fns/user-update]}
     {:role-name language-admin-rname
      :functionalities [fns/language-create
                        fns/language-read
                        fns/language-update
                        fns/language-delete]}
     {:role-name language-mod-rname
      :functionalities [fns/language-read
                        fns/language-update]}
     {:role-name role-admin-rname
      :functionalities [fns/role-create
                        fns/role-read
                        fns/role-update
                        fns/role-delete]}
     {:role-name role-mod-rname
      :functionalities [fns/role-read
                        fns/role-update]}                       
     {:role-name grocery-admin-rname
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
                        pomfns/organism-update]}])
  (let [user-admin-id (:_id
                        (mon/mongodb-find-one
                          role-cname
                          {:role-name user-admin-rname}))
        language-admin-id (:_id
                            (mon/mongodb-find-one
                              role-cname
                              {:role-name language-admin-rname}))
        role-admin-id (:_id
                        (mon/mongodb-find-one
                          role-cname
                          {:role-name role-admin-rname}))
        grocery-admin-id (:_id
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
        encrypted-password (utils/encrypt-password
                             (or (System/getenv "ADMIN_USER_PASSWORD")
                                 "123"))]
    (mon/mongodb-insert-one
      user-cname
      {:username "admin"
       :email "123@123"
       :password encrypted-password
       :roles [user-admin-id
               language-admin-id
               role-admin-id
               grocery-admin-id
               meal-admin-id
               organism-admin-id]}))
  (let [user-id (:_id
                  (mon/mongodb-find-one
                    user-cname
                    {}))]
    (mon/mongodb-insert-one
      preferences-cname
      {:user-id user-id
       :language "serbian"
       :language-name "Srpski"}))
  (mon/mongodb-insert-one
    db-updates-cname
    {:initialized true
     :date (java.util.Date.)})
 )

(defn db-update-1
  "Database update 1"
  []
  (mon/mongodb-insert-many
    language-cname
    [{:code 1029
      :english "Add at least one ingredient"
      :serbian "Додајте бар један састојак"}])
  (mon/mongodb-insert-one
    db-updates-cname
    {:update 1
     :date (java.util.Date.)})
 )

(defn db-update-2
  "Database update 2"
  []
  (mon/mongodb-insert-many
    language-cname
    [{:code 1030 :english "Breakfast" :serbian "Доручак"}
     {:code 1031 :english "Lunch" :serbian "Ручак"}
     {:code 1032 :english "Dinner" :serbian "Вечера"}
     {:code 1033 :english "Main course" :serbian "Главно јело"}
     {:code 1034 :english "Sauce" :serbian "СОС"}
     {:code 1035 :english "Beverage" :serbian "Пиће"}
     {:code 1036 :english "Soup" :serbian "Супа"}
     {:code 1037 :english "Sweets, Cake, Compote, Ice cream" :serbian "Слаткиши, Торте, Компот, Сладолед"}
     {:code 1038 :english "Salad" :serbian "Салата"}
     {:code 1039 :english "No ingredients" :serbian "Без састојака"}
     {:code 32 :english "-- Select one --" :serbian "-- Одабери један --"}
     {:code 1040 :english "Ingredients" :serbian "Састојци"}
     {:code 1041 :english "Add" :serbian "Додај"}
     {:code 1042 :english "All" :serbian "Све"}
     {:code 1043 :english "Vegetarian" :serbian "Вегетаријанско"}
     {:code 1044 :english "Vegetarian" :serbian "Вегетаријанска"}
     {:code 1045 :english "Mainly sitting" :serbian "Углавном седеће"}
     {:code 1046 :english "Easy physical labor" :serbian "Лак физички рад"}
     {:code 1047 :english "Medium physical labor" :serbian "Средње тежак физички рад"}
     {:code 1048 :english "Hard physical labor" :serbian "Тежак физички рад"}
     {:code 1049 :english "Very hard physical labor" :serbian "Веома тежак физички рад"}
     {:code 1050 :english "Male" :serbian "Мушки"}
     {:code 1051 :english "Female" :serbian "Женски"}])
  (mon/mongodb-insert-one
    db-updates-cname
    {:update 2
     :date (java.util.Date.)})
 )

(defn initialize-db-if-needed
  "Check if database exists and initialize it if it doesn't"
  []
  (try
    (when-not (mon/mongodb-exists
                db-updates-cname
                {:initialized true})
      (initialize-db))
    (when-not (mon/mongodb-exists
                db-updates-cname
                {:update 1})
      (db-update-1))
    (when-not (mon/mongodb-exists
                db-updates-cname
                {:update 2})
      (db-update-2))
    (catch Exception e
      (println e))
   ))

