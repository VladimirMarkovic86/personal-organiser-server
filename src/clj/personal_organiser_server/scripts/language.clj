(ns personal-organiser-server.scripts.language
  (:require [mongo-lib.core :as mon]
            [common-middle.collection-names :refer [language-cname]]))

(defn insert-labels
  "Inserts labels"
  []
  (mon/mongodb-insert-many
    language-cname
    [{ :code 1001 :english "First name" :serbian "Име" }
     { :code 1002 :english "Last name" :serbian "Презиме" }
     { :code 1003 :english "Height" :serbian "Висина" }
     { :code 1004 :english "Weight" :serbian "Тежина" }
     { :code 1005 :english "Birthday" :serbian "Датум рођења" }
     { :code 1006 :english "Gender" :serbian "Пол" }
     { :code 1007 :english "Diet" :serbian "Исхрана" }
     { :code 1008 :english "Activity" :serbian "Активности" }
     { :code 1009 :english "Grocery" :serbian "Намирница" }
     { :code 1010 :english "Name" :serbian "Назив" }
     { :code 1011 :english "Calories" :serbian "Калорије" }
     { :code 1012 :english "Proteins" :serbian "Протеини" }
     { :code 1013 :english "Fats" :serbian "Масти" }
     { :code 1014
	      :english "Carbonhydrates"
	      :serbian "Угљени хидрати" }
     { :code 1015 :english "Description" :serbian "Опис" }
     { :code 1016 :english "Origin" :serbian "Порекло" }
     { :code 1017 :english "Meal" :serbian "Оброк" }
     { :code 1018 :english "Calories sum" :serbian "Укупно калорија" }
     { :code 1019 :english "Proteins sum" :serbian "Укупно протеина" }
     { :code 1020 :english "Fats sum" :serbian "Укупно масти" }
     { :code 1021
	      :english "Carbonhydrates sum"
	      :serbian "Укупно угљених хидрата" }
     { :code 1022 :english "Image" :serbian "Слика" }
     { :code 1023 :english "Type of meal" :serbian "Врста оброка" }
     { :code 1024 :english "Part of meal" :serbian "Део оброка" }
     { :code 1025 :english "Ingrediants" :serbian "Састојци" }
     { :code 1026 :english "Organism" :serbian "Организам" }
     { :code 1027 :english "Grams" :serbian "Грама" }
     { :code 1028 :english "Quantity" :serbian "Квантитет" }
     { :code 1029
	      :english "Add at least one ingredient"
	      :serbian "Додајте бар један састојак" }
     { :code 1030 :english "Breakfast" :serbian "Доручак" }
     { :code 1031 :english "Lunch" :serbian "Ручак" }
     { :code 1032 :english "Dinner" :serbian "Вечера" }
     { :code 1033 :english "Main course" :serbian "Главно јело" }
     { :code 1034 :english "Sauce" :serbian "СОС" }
     { :code 1035 :english "Beverage" :serbian "Пиће" }
     { :code 1036 :english "Soup" :serbian "Супа" }
     { :code 1037
	      :english "Sweets, Cake, Compote, Ice cream"
	      :serbian "Слаткиши, Торте, Компот, Сладолед" }
     { :code 1038 :english "Salad" :serbian "Салата" }
     { :code 1039 :english "No ingredients" :serbian "Без састојака" }
     { :code 1040 :english "Ingredients" :serbian "Састојци" }
     { :code 1041 :english "Add" :serbian "Додај" }
     { :code 1042
	      :english "Not vegetarian"
	      :serbian "Не вегетарианска" }
     { :code 1043 :english "Vegetarian" :serbian "Вегетаријанско" }
     { :code 1044 :english "Vegetarian" :serbian "Вегетаријанска" }
     { :code 1045
	      :english "Mainly sitting"
	      :serbian "Углавном седеће" }
     { :code 1046
	      :english "Easy physical labor"
	      :serbian "Лак физички рад" }
     { :code 1047
	      :english "Medium physical labor"
	      :serbian "Средње тежак физички рад" }
     { :code 1048
	      :english "Hard physical labor"
	      :serbian "Тежак физички рад" }
     { :code 1049
	      :english "Very hard physical labor"
	      :serbian "Веома тежак физички рад" }
     { :code 1050 :english "Male" :serbian "Мушки" }
     { :code 1051 :english "Female" :serbian "Женски" }
     { :code 1052 :english "Group" :serbian "Група" }
     { :code 1053 :english "Group I" :serbian "Група I" }
     { :code 1054
	      :english "Cereals and their productsflour, wheat, bread, pastry, pasta"
	      :serbian "Житарице и њихови производибрашно, гриз, хлеб, пециво, тестенине" }
     { :code 1055 :english "Group II" :serbian "Група II" }
     { :code 1056
	      :english "Milk and milk productsyoghurt, sour milk, cheese, etc."
	      :serbian "Млеко и млечни производијогурт, кисело млеко, кајмак, сир и др." }
     { :code 1057 :english "Group III" :serbian "Група III" }
     { :code 1058
	      :english "Meat, fish and eggs and products of these groceries"
	      :serbian "Месо, рибе и јаја и прерађевине од ових намирница" }
     { :code 1059 :english "Group IV" :serbian "Група IV" }
     { :code 1060
	      :english "Fats and oils (all types of fats, including butter etc.)"
	      :serbian "Масти и уља (све врсте масти, укључујући маслац, маргарин и сл.)" }
     { :code 1061 :english "Group V" :serbian "Група V" }
     { :code 1062 :english "Vegetables" :serbian "Поврће" }
     { :code 1063 :english "Group VI" :serbian "Група VI" }
     { :code 1064 :english "Fruits" :serbian "Воће" }
     { :code 1065 :english "Group VII" :serbian "Група VI" }
     { :code 1066
	      :english "Sugar and sugar concentrateshoney, sweet, jam, chocolate, etc."
	      :serbian "Шећер и шећерни концентратимед, слатко, џем, чоколада и др." }
     { :code 1067 :english "All in one" :serbian "Све заједно" }
     { :code 1068 :english "Calculate" :serbian "Рачунај" }
     { :code 1069
	      :english "Meal recommendation"
	      :serbian "Препорука оброка" }
     { :code 1070 :english "Rice" :serbian "Пиринач" }
     { :code 1071 :english "Wheat semolina" :serbian "Пшенични гриз" }
     { :code 1072 :english "Corn semolina" :serbian "Кукурузни гриз" }
     { :code 1073
	      :english "Wheat flour (type 1100)"
	      :serbian "Пшенично брашно (тип 1100)" }
     { :code 1074
	      :english "Wheat flour (type 600)"
	      :serbian "Пшенично брашно (тип 600)" }
     { :code 1075
	      :english "Wheat flour (type 400)"
	      :serbian "Пшенично брашно (тип 400)" }
     { :code 1076 :english "Corn flour" :serbian "Кукурузно брашно" }
     { :code 1077
	      :english "Rye flour white"
	      :serbian "Ражено брашно бело" }
     { :code 1078
	      :english "Rye flour black"
	      :serbian "Ражено брашно црно" }
     { :code 1079 :english "Rice flour" :serbian "Пиринчано брашно" }
     { :code 1080
	      :english "Potato flour"
	      :serbian "Кромпирово брашно" }
     { :code 1081
	      :english "Soya flour fatty"
	      :serbian "Сојино брашно масно" }
     { :code 1082
	      :english "Buckwheat flour black"
	      :serbian "Хељда брашно црно" }
     { :code 1083
	      :english "Buckwheat flour white"
	      :serbian "Хељдино брашно бело" }
     { :code 1084
	      :english "Wheat bread (black 80%)"
	      :serbian "Пшенични хлеб (црни 80%)" }
     { :code 1085
	      :english "Wheat bread (half white 70%)"
	      :serbian "Пшенични хлеб (полу бели 70%)" }
     { :code 1086 :english "Corn bread" :serbian "Кукурузни хлеб" }
     { :code 1087 :english "Toast" :serbian "Двопек" }
     { :code 1088 :english "Biscuits" :serbian "Кекс" }
     { :code 1089
	      :english "Macaroni noodles"
	      :serbian "Макарони резанци" }
     { :code 1090 :english "Oatmeal" :serbian "Овсене пахуљице" }
     { :code 1091 :english "Cow's milk" :serbian "Млеко кравље" }
     { :code 1092
	      :english "Skimmed cow's milk"
	      :serbian "Млеко кравље обрано" }
     { :code 1093 :english "Goat's milk" :serbian "Млеко козје" }
     { :code 1094 :english "Sheep's milk" :serbian "Млеко овчје" }
     { :code 1095
	      :english "Skimmed milk powder"
	      :serbian "Млеко у праху обрано" }
     { :code 1096
	      :english "Milk powder fatty"
	      :serbian "Млеко у праху пуномасно" }
     { :code 1097
	      :english "Milk condensed unsweetened"
	      :serbian "Млеко кондензовано неслађено" }
     { :code 1098
	      :english "Milk condensed sweetened"
	      :serbian "Млеко кондензовано слатко" }
     { :code 1099 :english "Woman's milk" :serbian "Млеко женино" }
     { :code 1100
	      :english "Sour cream sweet"
	      :serbian "Павлака слатка" }
     { :code 1101 :english "Sour cream" :serbian "Павлака кисела" }
     { :code 1102
	      :english "Buttermilk (churn)"
	      :serbian "Млаћеница (степка)" }
     { :code 1103
	      :english "Buttermilk kefir"
	      :serbian "Млаћеница кефир" }
     { :code 1104
	      :english "Buttermilk yogurt"
	      :serbian "Млаћеница јогурт" }
     { :code 1105
	      :english "Buttermilk curd"
	      :serbian "Млаћеница сурутка" }
     { :code 1106
	      :english "Buttermilk sour milk"
	      :serbian "Млаћеница кисело млеко" }
     { :code 1107
	      :english "Cow's fresh cheese"
	      :serbian "Сир крављи свеж (млад)" }
     { :code 1108
	      :english "Cheese full fat"
	      :serbian "Сир пуномасни" }
     { :code 1109
	      :english "Cheese half fat (35%)"
	      :serbian "Сир полумасни (35%)" }
     { :code 1110
	      :english "Cheese fat (20%)"
	      :serbian "Сир масни (20%)" }
     { :code 1111
	      :english "Cheese fat (2%)"
	      :serbian "Сир масни (2%)" }
     { :code 1112
	      :english "Cheese \"Zdenka\""
	      :serbian "Сир \"Зденка\"" }
     { :code 1113 :english "Cheese" :serbian "Сир качкаваљ" }
     { :code 1114 :english "Butter" :serbian "Бутер (маслац)" }
     { :code 1115
	      :english "Meat fresh beef medium fat"
	      :serbian "Месо свеже говеђе масно средње" }
     { :code 1116
	      :english "Meat fresh veal medium fat"
	      :serbian "Месо свеже телеће масно средње" }
     { :code 1117
	      :english "Meat fresh pork medium fat"
	      :serbian "Месо свеже свињско масно средње" }
     { :code 1118
	      :english "Meat fresh sheep medium fat"
	      :serbian "Месо свеже овчје масно средње" }
     { :code 1119
	      :english "Meat fresh lamb medium fat"
	      :serbian "Месо свеже јагњеће масно средње" }
     { :code 1120
	      :english "Meat fresh horse medium fat"
	      :serbian "Месо свеже коњско масно средње" }
     { :code 1121
	      :english "Meat fresh rabbit medium fat"
	      :serbian "Месо свеже кунића масно средње" }
     { :code 1122
	      :english "Tongue (beef veal pork)"
	      :serbian "Језик (говеђи телећи свињски)" }
     { :code 1123 :english "Veal's heart" :serbian "Срце телеће" }
     { :code 1124 :english "Veal's liver" :serbian "Јетра телећа" }
     { :code 1125 :english "Beef's liver" :serbian "Јетра говеђа" }
     { :code 1126 :english "Pork liver" :serbian "Јетра свињска" }
     { :code 1127 :english "Kidneys" :serbian "Бубрези" }
     { :code 1128 :english "Spleen" :serbian "Слезина" }
     { :code 1129 :english "Veal's lungs" :serbian "Плућа телећа" }
     { :code 1130 :english "Veal's brain" :serbian "Мозак телећи" }
     { :code 1131 :english "Tripe" :serbian "Шкембићи" }
     { :code 1132
	      :english "Meat products hot dogs"
	      :serbian "Месне прерађевине хреновке" }
     { :code 1133
	      :english "Meat products beef's sausages"
	      :serbian "Месне прерађевине Кобасице говеђе" }
     { :code 1134
	      :english "Meat products \"Gavrilović\" salami"
	      :serbian "Месне прерађевине \"Гавриловићева\" салама" }
     { :code 1135
	      :english "Meat products ham"
	      :serbian "Месне прерађевине Шункарица" }
     { :code 1136
	      :english "Meat products liver"
	      :serbian "Месне прерађевине Џигерица" }
     { :code 1137
	      :english "Dried meat pork"
	      :serbian "Суво месо свињско" }
     { :code 1138
	      :english "Dry meat ham medium fat"
	      :serbian "Суво месо Шунка средње масна" }
     { :code 1139
	      :english "Dry meat dried bacon"
	      :serbian "Суво месо Сува сланина" }
     { :code 1140 :english "Fowl chicken" :serbian "Живина кокошка" }
     { :code 1141 :english "Fowl chick" :serbian "Живина Пиле" }
     { :code 1142 :english "Fowl turkey" :serbian "Живина Ћурка" }
     { :code 1143 :english "Fowl goose" :serbian "Живина Гуска" }
     { :code 1144 :english "Fowl duck" :serbian "Живина Патка" }
     { :code 1145 :english "Fish carp" :serbian "Риба шаран" }
     { :code 1146 :english "Fish pike" :serbian "Риба Штука" }
     { :code 1147 :english "Fish trout" :serbian "Риба Пастрмка" }
     { :code 1148
	      :english "Fish whitefish"
	      :serbian "Риба Беле рибе" }
     { :code 1149
	      :english "Fish sardines in oil"
	      :serbian "Риба Сардина у уљу" }
     { :code 1150 :english "River's crab" :serbian "Рак речни" }
     { :code 1151
	      :english "Chicken's eggs  (2 pcs. 100g)"
	      :serbian "Јаја кокошија (2 ком. 100g)" }
     { :code 1152
	      :english "Chicken's eggs  (2 pcs. 100g egg white)"
	      :serbian "Јаја кокошија (2 ком. 100g Беланце)" }
     { :code 1153
	      :english "Chicken's eggs  (2 pcs. 100g yolk)"
	      :serbian "Јаја кокошија (2 ком. 100g Жуманце)" }
     { :code 1154 :english "Egg powder" :serbian "Јаја у праху" }
     { :code 1155 :english "Duck eggs" :serbian "Јаја Пачја" }
     { :code 1156 :english "Goose eggs" :serbian "Јаја Гушчја" }
     { :code 1157 :english "Pork fat" :serbian "Маст свињска" }
     { :code 1158 :english "Goose fat" :serbian "Маст Гушчја" }
     { :code 1159 :english "Coconut fat" :serbian "Маст Кокосова" }
     { :code 1160 :english "Butterfat" :serbian "Масло" }
     { :code 1161 :english "Margarine" :serbian "Маргарин" }
     { :code 1162 :english "Oil" :serbian "Уље" }
     { :code 1163 :english "Cracklings" :serbian "Чварци" }
     { :code 1164 :english "Broad bean fresh" :serbian "Боб свеж" }
     { :code 1165 :english "Broad bean dried" :serbian "Боб суви" }
     { :code 1166 :english "Green beans" :serbian "Боранија" }
     { :code 1167 :english "Green peas" :serbian "Грашак зелени" }
     { :code 1168 :english "Dried peas" :serbian "Грашак суви" }
     { :code 1169 :english "Kohlrabi" :serbian "Келераба" }
     { :code 1170 :english "Cauliflower" :serbian "Карфиол" }
     { :code 1171 :english "Kale" :serbian "Кељ" }
     { :code 1172 :english "Cucumbers" :serbian "Краставци" }
     { :code 1173 :english "Sour cabbage" :serbian "Купус кисели" }
     { :code 1174 :english "Fresh cabbage" :serbian "Купус свеж" }
     { :code 1175 :english "Garlic" :serbian "Лук бели" }
     { :code 1176 :english "Onion" :serbian "Лук црни" }
     { :code 1177 :english "Leek" :serbian "Празилук" }
     { :code 1178 :english "Beans" :serbian "Пасуљ" }
     { :code 1179
	      :english "Parsnip (green)"
	      :serbian "Пашканат (зелен)" }
     { :code 1180 :english "Parsley" :serbian "Першун" }
     { :code 1181 :english "Paprika green" :serbian "Паприка зелена" }
     { :code 1182 :english "Paprika red" :serbian "Паприка црвена" }
     { :code 1183 :english "Paprika sour" :serbian "Паприка кисела" }
     { :code 1184 :english "Tomato fresh" :serbian "Парадајз свеж" }
     { :code 1185
	      :english "Tomatoes cooked"
	      :serbian "Парадајз кувани" }
     { :code 1186
	      :english "Mushrooms fresh"
	      :serbian "Печурке свеже" }
     { :code 1187 :english "Mushrooms dried" :serbian "Печурке суве" }
     { :code 1188 :english "Radish" :serbian "Ротквице" }
     { :code 1189 :english "Lentil" :serbian "Сочиво" }
     { :code 1190 :english "Spinach" :serbian "Спанаћ" }
     { :code 1191 :english "Salad green" :serbian "Салата зелена" }
     { :code 1192 :english "Horseradish" :serbian "Хрен" }
     { :code 1193 :english "Celery" :serbian "Целер" }
     { :code 1194 :english "Beet" :serbian "Цвекла" }
     { :code 1195 :english "Carrot" :serbian "Шаргарепа" }
     { :code 1196 :english "Asparagus" :serbian "Шпаргла" }
     { :code 1197 :english "Zucchini" :serbian "Тиквице" }
     { :code 1198 :english "Pineapple" :serbian "Ананас" }
     { :code 1199 :english "Peach" :serbian "Брескве" }
     { :code 1200 :english "Almond dry" :serbian "Бадем суви" }
     { :code 1201 :english "Blueberries" :serbian "Боровнице" }
     { :code 1202 :english "Cranberries" :serbian "Бруснице" }
     { :code 1203 :english "Bananas" :serbian "Банане" }
     { :code 1204 :english "Grapes" :serbian "Грожђе" }
     { :code 1205 :english "Grape" :serbian "Грапе" }
     { :code 1206 :english "Melon" :serbian "Диња" }
     { :code 1207 :english "Quince" :serbian "Дуње" }
     { :code 1208 :english "Apples" :serbian "Јабуке" }
     { :code 1209 :english "Strawberries" :serbian "Јагоде" }
     { :code 1210 :english "Peanuts" :serbian "Кикирики" }
     { :code 1211 :english "Coconut" :serbian "Кокосов орах" }
     { :code 1212 :english "Pears" :serbian "Крушке" }
     { :code 1213 :english "Apricot" :serbian "Кајсије" }
     { :code 1214 :english "Chestnut fresh" :serbian "Кестен свеж" }
     { :code 1215 :english "Blackberry" :serbian "Купине" }
     { :code 1216 :english "Watermelon" :serbian "Лубенице" }
     { :code 1217 :english "Hazelnut" :serbian "Лешник" }
     { :code 1218 :english "Lemon" :serbian "Лимун" }
     { :code 1219 :english "Raspberry" :serbian "Малине" }
     { :code 1220
	      :english "Walnuts (without shell)"
	      :serbian "Ораси (без љуске)" }
     { :code 1221 :english "Gooseberry" :serbian "Огрозд" }
     { :code 1222 :english "Orange" :serbian "Поморанџе" }
     { :code 1223 :english "Currant" :serbian "Рибизле" }
     { :code 1224 :english "Roščići" :serbian "Рошчићи" }
     { :code 1225 :english "Cherries" :serbian "Трешње" }
     { :code 1226 :english "Figs fresh" :serbian "Смокве свеже" }
     { :code 1227 :english "Figs dried" :serbian "Смокве суве" }
     { :code 1228 :english "Plums fresh" :serbian "Шљиве свеже" }
     { :code 1229 :english "Plums dried" :serbian "Шљиве суве" }
     { :code 1230 :english "Eglantine" :serbian "Шипак" }
     { :code 1231 :english "Urme" :serbian "Урме" }
     { :code 1232 :english "Grapes dry" :serbian "Грожђе суво" }
     { :code 1233 :english "Sugar" :serbian "Шећер" }
     { :code 1234 :english "Marmalade jam" :serbian "Мармелада џем" }
     { :code 1235 :english "Pekmez" :serbian "Пекмез" }
     { :code 1236 :english "Honey" :serbian "Мед" }
     { :code 1237
	      :english "Milk chocolate"
	      :serbian "Чоколада млечна" }
     { :code 1238
	      :english "Chocolate for cooking"
	      :serbian "Чоколада за кување" }
     { :code 1239
	      :english "Chocolate with hazelnut"
	      :serbian "Чоколада са лешником" }
     { :code 1240 :english "Cocoa" :serbian "Какао" }
     { :code 1241
	      :english "Chocolate candy"
	      :serbian "Бомбоне чоколадне" }
     { :code 1242 :english "Fruit candy" :serbian "Бомбоне воћне" }
     { :code 1243
	      :english "Fruit juice with sugar"
	      :serbian "Воћни сок са шећером" }
     { :code 1244
	      :english "Raspberry syrup"
	      :serbian "Малинов сируп" }
     { :code 1245
	      :english "Brandy (25% alcohol)"
	      :serbian "Ракија (25% алкохола)" }
     { :code 1246
	      :english "Wine (10% alcohol)"
	      :serbian "Вино (10% алкохола)" }
     { :code 1247
	      :english "Beer (4% alcohol)"
	      :serbian "Пиво (4% алкохола)" }
     { :code 1248
	      :english "Cognac (50% alcohol)"
	      :serbian "Коњак (50% алкохола)" }
     { :code 1249
	      :english "Rum (40% alcohol)"
	      :serbian "Рум (40% алкохола)" }
     { :code 1250 :english "Olives" :serbian "Маслине" }
     { :code 1251 :english "Ketchup mild" :serbian "Кечап благи" }
     { :code 1252
	      :english "Ketchup pizza and pasta"
	      :serbian "Кечап пица и паста" }
     { :code 1253 :english "Artichoke" :serbian "Артичока" }
     { :code 1254 :english "Potato fresh" :serbian "Кромпир свеж" }
     { :code 1255 :english "Potato dried" :serbian "Кромпир суви" }
     { :code 1256
	      :english "Corn flakes"
	      :serbian "Кукурузне пахуљице" }
     { :code 1257
	      :english "Bake rolls garlic"
	      :serbian "Двопек са укусом белог лука" }
     { :code 1258
	      :english "Bake rolls pizza"
	      :serbian "Двопек са укусом пице" }
     { :code 1259
	      :english "Bake rolls bacon"
	      :serbian "Двопек са укусом сланине" }
     { :code 1260
	      :english "Breakfast's daily calories share in percents"
	      :serbian "Процентуални удео доручка у дневним потребама за калоријама" }
     { :code 1261
	      :english "Lunch's daily calories share in percents"
	      :serbian "Процентуални удео ручка у дневним потребама за калоријама" }
     { :code 1262
	      :english "Dinner's daily calories share in percents"
	      :serbian "Процентуални удео вечере у дневним потребама за калоријама" }
     ]))

