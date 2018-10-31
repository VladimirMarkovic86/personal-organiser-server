(ns personal-organiser-server.scripts
  (:require [mongo-lib.core :as mon]
            [utils-lib.core :as utils]))

(defn initialize-db
  "Initialize database"
  []
  (mon/mongodb-insert-many
    "language"
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
    "role"
    [{ :role-name "User administrator", :functionalities [ "user-create", "user-read", "user-update", "user-delete" ] }
     { :role-name "User moderator", :functionalities [ "user-read", "user-update" ] }
     { :role-name "Language administrator", :functionalities [ "language-create", "language-read", "language-update", "language-delete" ] }
     { :role-name "Language moderator", :functionalities [ "language-read", "language-update" ] }
     { :role-name "Role administrator", :functionalities [ "role-create", "role-read", "role-update", "role-delete" ] }
     { :role-name "Role moderator", :functionalities [ "role-read", "role-update" ] }
     { :role-name "Grocery administrator", :functionalities [ "grocery-create", "grocery-read", "grocery-update", "grocery-delete" ] }
     { :role-name "Grocery moderator", :functionalities [ "grocery-read", "grocery-update" ] }
     { :role-name "Meal administrator", :functionalities [ "meal-create", "meal-read", "meal-update", "meal-delete" ] }
     { :role-name "Meal moderator", :functionalities [ "meal-read", "meal-update" ] }
     { :role-name "Organism administrator", :functionalities [ "organism-create", "organism-read", "organism-update", "organism-delete" ] }
     { :role-name "Organism moderator", :functionalities [ "organism-read", "organism-update" ] }])
  (let [user-admin-id (:_id
                        (mon/mongodb-find-one
                          "role"
                          {:role-name "User administrator"}))
        language-admin-id (:_id
                            (mon/mongodb-find-one
                              "role"
                              {:role-name "Language administrator"}))
        role-admin-id (:_id
                        (mon/mongodb-find-one
                          "role"
                          {:role-name "Role administrator"}))
        grocery-admin-id (:_id
                           (mon/mongodb-find-one
                             "role"
                             {:role-name "Grocery administrator"}))
        meal-admin-id (:_id
                        (mon/mongodb-find-one
                          "role"
                          {:role-name "Meal administrator"}))
        organism-admin-id (:_id
                            (mon/mongodb-find-one
                              "role"
                              {:role-name "Organism administrator"}))
        encrypted-password (utils/encrypt-password
                             (or (System/getenv "ADMIN_USER_PASSWORD")
                                 "123"))]
    (mon/mongodb-insert-one
      "user"
      {:username "admin"
       :email "123@123"
       :password encrypted-password
       :roles [user-admin-id language-admin-id role-admin-id grocery-admin-id meal-admin-id organism-admin-id]}))
  (let [user-id (:_id
                  (mon/mongodb-find-one
                    "user"
                    {}))]
    (mon/mongodb-insert-one
      "preferences"
      {:user-id user-id, :language "serbian", :language-name "Srpski" }))
 )

(defn initialize-db-if-needed
  "Check if database exists and initialize it if it doesn't"
  []
  (try
    (when-not (mon/mongodb-exists
                "language"
                {:english "Save"})
      (initialize-db))
    (catch Exception e
      (println e))
   ))

