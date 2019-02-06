(ns personal-organiser-server.scripts.grocery
  (:require [mongo-lib.core :as mon]
            [personal-organiser-middle.collection-names :refer [grocery-cname]]))

(defn insert-groceries
  "Inserts groceries"
  []
  (mon/mongodb-insert-many
    grocery-cname
    [{:gname "Пиринач"
	     :calories 357
	     :proteins 7.5
	     :fats 1.6
	     :carbonhydrates 75.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1070
     }
     {:gname "Пшенични гриз"
	     :calories 351
	     :proteins 9.4
	     :fats 0.2
	     :carbonhydrates 75.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1071
     }
     {:gname "Кукурузни гриз"
	     :calories 366
	     :proteins 8.3
	     :fats 1.1
	     :carbonhydrates 78
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1072
     }
     {:gname "Пшенично брашно (тип 1100)"
	     :calories 364
	     :proteins 12
	     :fats 1.7
	     :carbonhydrates 73
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1073
     }
     {:gname "Пшенично брашно (тип 600)"
	     :calories 363
	     :proteins 11
	     :fats 1
	     :carbonhydrates 75
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1074
     }
     {:gname "Пшенично брашно (тип 400)"
	     :calories 363
	     :proteins 10
	     :fats 0.9
	     :carbonhydrates 76
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1075
     }
     {:gname "Кукурузно брашно"
	     :calories 368
	     :proteins 7.8
	     :fats 2.6
	     :carbonhydrates 76
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1076
     }
     {:gname "Ражено брашно бело"
	     :calories 356
	     :proteins 9.4
	     :fats 1
	     :carbonhydrates 75.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1077
     }
     {:gname "Ражено брашно црно"
	     :calories 350
	     :proteins 8
	     :fats 1.5
	     :carbonhydrates 74
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1078
     }
     {:gname "Пиринчано брашно"
	     :calories 360
	     :proteins 7.4
	     :fats 0.7
	     :carbonhydrates 79
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1079
     }
     {:gname "Кромпирово брашно"
	     :calories 349
	     :proteins 8.5
	     :fats 0.4
	     :carbonhydrates 75.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1080
     }
     {:gname "Сојино брашно масно"
	     :calories 455
	     :proteins 34
	     :fats 19
	     :carbonhydrates 34
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1081
     }
     {:gname "Хељда брашно црно"
	     :calories 347
	     :proteins 11.7
	     :fats 2.5
	     :carbonhydrates 67.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1082
     }
     {:gname "Хељдино брашно бело"
	     :calories 348
	     :proteins 6.4
	     :fats 1.2
	     :carbonhydrates 75.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1083
     }
     {:gname "Пшенични хлеб (црни 80%)"
	     :calories 246
	     :proteins 8.1
	     :fats 0.3
	     :carbonhydrates 51.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1084
     }
     {:gname "Пшенични хлеб (полубели 70%)"
	     :calories 235
	     :proteins 7.5
	     :fats 0.4
	     :carbonhydrates 49
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1085
     }
     {:gname "Кукурузни хлеб"
	     :calories 227
	     :proteins 5.8
	     :fats 1.7
	     :carbonhydrates 45.7
	     :description "Извор података\nВелики народни кувар"
	     :group [
		     "group_i"
	     ]
	     :label-code 1086
	     :diet "vegetarian"
     }
     {:gname "Двопек"
	     :calories 374
	     :proteins 9.9
	     :fats 2.6
	     :carbonhydrates 75.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1087
     }
     {:gname "Кекс"
	     :calories 405
	     :proteins 8.6
	     :fats 10.4
	     :carbonhydrates 66.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1088
     }
     {:gname "Макарони резанци"
	     :calories 373
	     :proteins 12.9
	     :fats 0.7
	     :carbonhydrates 76.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1089
     }
     {:gname "Овсене пахуљице"
	     :calories 390
	     :proteins 14.2
	     :fats 7.4
	     :carbonhydrates 64.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_i"
	     ]
	     :label-code 1090
     }
     {:gname "Млеко кравље"
	     :calories 67
	     :proteins 3.4
	     :fats 3.6
	     :carbonhydrates 4.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1091
     }
     {:gname "Млеко кравље обрано"
	     :calories 36
	     :proteins 3.5
	     :fats 0.1
	     :carbonhydrates 5.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1092
     }
     {:gname "Млеко козје"
	     :calories 73
	     :proteins 3.8
	     :fats 4.5
	     :carbonhydrates 3.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1093
     }
     {:gname "Млеко овчје"
	     :calories 99
	     :proteins 5.8
	     :fats 6.5
	     :carbonhydrates 3.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1094
     }
     {:gname "Млеко у праху обрано"
	     :calories 362
	     :proteins 35.6
	     :fats 1
	     :carbonhydrates 52
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1095
     }
     {:gname "Млеко у праху пуномасно"
	     :calories 492
	     :proteins 25.8
	     :fats 26.7
	     :carbonhydrates 38
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1096
     }
     {:gname "Млеко кондензовано неслађено"
	     :calories 161
	     :proteins 8.1
	     :fats 9
	     :carbonhydrates 10.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1097
     }
     {:gname "Млеко кондензовано слатко"
	     :calories 320
	     :proteins 8.1
	     :fats 8.4
	     :carbonhydrates 50.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1098
     }
     {:gname "Млеко женино"
	     :calories 80
	     :proteins 1.3
	     :fats 3.8
	     :carbonhydrates 6.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1099
     }
     {:gname "Павлака слатка"
	     :calories 339
	     :proteins 2.7
	     :fats 34
	     :carbonhydrates 3
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1100
     }
     {:gname "Павлака кисела"
	     :calories 214
	     :proteins 3.7
	     :fats 20
	     :carbonhydrates 3.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1101
     }
     {:gname "Млаћеница (степка)"
	     :calories 37
	     :proteins 3.7
	     :fats 0.7
	     :carbonhydrates 3.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1102
     }
     {:gname "Млаћеница кефир"
	     :calories 52
	     :proteins 3.1
	     :fats 3.1
	     :carbonhydrates 2.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1103
     }
     {:gname "Млаћеница јогурт"
	     :calories 52
	     :proteins 3.3
	     :fats 3.1
	     :carbonhydrates 2.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1104
     }
     {:gname "Млаћеница сурутка"
	     :calories 26
	     :proteins 0.3
	     :fats 0.1
	     :carbonhydrates 6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1105
     }
     {:gname "Млаћеница кисело млеко"
	     :calories 64
	     :proteins 3.3
	     :fats 3.3
	     :carbonhydrates 4.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1106
     }
     {:gname "Сир крављи свеж (млад)"
	     :calories 97
	     :proteins 17
	     :fats 1.2
	     :carbonhydrates 4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1107
     }
     {:gname "Сир пуномасни"
	     :calories 371
	     :proteins 9
	     :fats 37
	     :carbonhydrates 2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1108
     }
     {:gname "Сир полумасни (35%)"
	     :calories 341
	     :proteins 34
	     :fats 21
	     :carbonhydrates 3
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1109
     }
     {:gname "Сир масни (20%)"
	     :calories 252
	     :proteins 36
	     :fats 10
	     :carbonhydrates 3
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1110
     }
     {:gname "Сир масни (2%)"
	     :calories 370
	     :proteins 27.5
	     :fats 28
	     :carbonhydrates 1.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1111
     }
     {:gname "Сир \"Зденка\""
	     :calories 355
	     :proteins 26.4
	     :fats 26.9
	     :carbonhydrates 1.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1112
     }
     {:gname "Сир качкаваљ"
	     :calories 390
	     :proteins 25
	     :fats 31
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1113
     }
     {:gname "Бутер (маслац)"
	     :calories 757
	     :proteins 0.6
	     :fats 81
	     :carbonhydrates 0.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_ii"
	     ]
	     :label-code 1114
     }
     {:gname "Месо свеже говеђе масно средње"
	     :calories 155
	     :proteins 19.6
	     :fats 7.8
	     :carbonhydrates 0.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1115
     }
     {:gname "Месо свеже телеће масно средње"
	     :calories 190
	     :proteins 19.1
	     :fats 12
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1116
     }
     {:gname "Месо свеже свињско масно средње"
	     :calories 350
	     :proteins 15.2
	     :fats 31
	     :carbonhydrates 0.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1117
     }
     {:gname "Месо свеже овчје масно средње"
	     :calories 317
	     :proteins 15.7
	     :fats 27.7
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1118
     }
     {:gname "Месо свеже јагњеће масно средње"
	     :calories 161
	     :proteins 21
	     :fats 8
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1119
     }
     {:gname "Месо      свеже      коњско      масно средње"
	     :calories 115
	     :proteins 21.5
	     :fats 2.5
	     :carbonhydrates 0.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1120
     }
     {:gname "Месо свеже кунића масно средње"
	     :calories 168
	     :proteins 21.6
	     :fats 8
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1121
     }
     {:gname "Језик (говеђи телећи свињски)"
	     :calories 228
	     :proteins 15.7
	     :fats 17.6
	     :carbonhydrates 0.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1122
     }
     {:gname "Срце телеће"
	     :calories 167
	     :proteins 17.6
	     :fats 10.1
	     :carbonhydrates 0.3
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1123
     }
     {:gname "Јетра телећа"
	     :calories 129
	     :proteins 19.9
	     :fats 3.7
	     :carbonhydrates 3.3
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1124
     }
     {:gname "Јетра говеђа"
	     :calories 132
	     :proteins 20
	     :fats 4
	     :carbonhydrates 4
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1125
     }
     {:gname "Јетра свињска"
	     :calories 135
	     :proteins 21
	     :fats 5
	     :carbonhydrates 1.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1126
     }
     {:gname "Бубрези"
	     :calories 118
	     :proteins 18.4
	     :fats 4.5
	     :carbonhydrates 0.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1127
     }
     {:gname "Слезина"
	     :calories 116
	     :proteins 17.8
	     :fats 4.2
	     :carbonhydrates 1
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1128
     }
     {:gname "Плућа телећа"
	     :calories 88
	     :proteins 15.2
	     :fats 2.5
	     :carbonhydrates 0.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1129
     }
     {:gname "Мозак телећи"
	     :calories 116
	     :proteins 9
	     :fats 8.6
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1130
     }
     {:gname "Шкембићи"
	     :calories 69
	     :proteins 13.5
	     :fats 1.4
	     :carbonhydrates 0.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1131
     }
     {:gname "Месне прерађевине хреновке"
	     :calories 170
	     :proteins 12
	     :fats 13
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1132
     }
     {:gname "Месне прерађевине Кобасице говеђе"
	     :calories 232
	     :proteins 21.7
	     :fats 15.4
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1133
     }
     {:gname "Месне прерађевине \"Гавриловићева\" салама"
	     :calories 564
	     :proteins 27.8
	     :fats 48.4
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1134
     }
     {:gname "Месне прерађевине Шункарица"
	     :calories 408
	     :proteins 19.2
	     :fats 34.4
	     :carbonhydrates 2.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1135
     }
     {:gname "Месне прерађевине Џигерица"
	     :calories 410
	     :proteins 16
	     :fats 35.9
	     :carbonhydrates 2.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1136
     }
     {:gname "Суво месо свињско"
	     :calories 326
	     :proteins 15
	     :fats 29
	     :carbonhydrates 1
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1137
     }
     {:gname "Суво месо Шунка средње масна"
	     :calories 335
	     :proteins 25
	     :fats 25
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1138
     }
     {:gname "Суво месо Сува сланина"
	     :calories 713
	     :proteins 9
	     :fats 72.8
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1139
     }
     {:gname "Живина кокошка"
	     :calories 167
	     :proteins 19.3
	     :fats 9.3
	     :carbonhydrates 0.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1140
     }
     {:gname "Живина Пиле"
	     :calories 151
	     :proteins 20.9
	     :fats 7.2
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1141
     }
     {:gname "Живина Ћурка"
	     :calories 157
	     :proteins 20.9
	     :fats 7.5
	     :carbonhydrates 0.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1142
     }
     {:gname "Живина Гуска"
	     :calories 208
	     :proteins 10
	     :fats 18
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1143
     }
     {:gname "Живина      Патка"
	     :calories 120
	     :proteins 22.5
	     :fats 2.8
	     :carbonhydrates 0.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1144
     }
     {:gname "Риба шаран"
	     :calories 149
	     :proteins 16.7
	     :fats 8.7
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1145
     }
     {:gname "Риба Штука"
	     :calories 80
	     :proteins 18.4
	     :fats 0.5
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1146
     }
     {:gname "Риба Пастрмка"
	     :calories 98
	     :proteins 19.2
	     :fats 2.1
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1147
     }
     {:gname "Риба Беле рибе"
	     :calories 154
	     :proteins 22.9
	     :fats 6.5
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1148
     }
     {:gname "Риба Сардина у уљу"
	     :calories 237
	     :proteins 23.9
	     :fats 14.4
	     :carbonhydrates 1.3
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1149
     }
     {:gname "Рак речни"
	     :calories 74
	     :proteins 16
	     :fats 0.5
	     :carbonhydrates 1
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1150
     }
     {:gname "Јаја кокошија (2 ком. 100g)"
	     :calories 162
	     :proteins 12.8
	     :fats 11.4
	     :carbonhydrates 0.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1151
     }
     {:gname "Јаја кокошија (2 ком. 100g Беланце)"
	     :calories 50
	     :proteins 11
	     :fats 0.2
	     :carbonhydrates 0.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1152
     }
     {:gname "Јаја кокошија (2 ком. 100g Жуманце)"
	     :calories 365
	     :proteins 16
	     :fats 3.2
	     :carbonhydrates 0.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1153
     }
     {:gname "Јаја у праху"
	     :calories 592
	     :proteins 46.8
	     :fats 42
	     :carbonhydrates 2.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1154
     }
     {:gname "Јаја Пачја"
	     :calories 164
	     :proteins 11.3
	     :fats 12.6
	     :carbonhydrates 0.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1155
     }
     {:gname "Јаја Гушчја"
	     :calories 162
	     :proteins 12.2
	     :fats 11.8
	     :carbonhydrates 0.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iii"
	     ]
	     :label-code 1156
     }
     {:gname "Маст свињска"
	     :calories 925
	     :proteins 0
	     :fats 99.5
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iv"
	     ]
	     :label-code 1157
     }
     {:gname "Маст Гушчја"
	     :calories 906
	     :proteins 0.5
	     :fats 97.2
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iv"
	     ]
	     :label-code 1158
     }
     {:gname "Маст Кокосова"
	     :calories 804
	     :proteins 0.7
	     :fats 85.9
	     :carbonhydrates 0.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iv"
	     ]
	     :label-code 1159
     }
     {:gname "Масло"
	     :calories 903
	     :proteins 0.1
	     :fats 97
	     :carbonhydrates 0.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iv"
	     ]
	     :label-code 1160
     }
     {:gname "Маргарин"
	     :calories 789
	     :proteins 0.5
	     :fats 84.5
	     :carbonhydrates 0.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iv"
	     ]
	     :label-code 1161
     }
     {:gname "Уље"
	     :calories 925
	     :proteins 0
	     :fats 99.5
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_iv"
	     ]
	     :label-code 1162
     }
     {:gname "Чварци"
	     :calories 713
	     :proteins 31.4
	     :fats 62.8
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "not_vegetarian"
	     :group [
		     "group_iv"
	     ]
	     :label-code 1163
     }
     {:gname "Боб свеж"
	     :calories 23
	     :proteins 2.3
	     :fats 0.1
	     :carbonhydrates 3
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1164
     }
     {:gname "Боб суви"
	     :calories 343
	     :proteins 23.7
	     :fats 2
	     :carbonhydrates 56.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1165
     }
     {:gname "Боранија"
	     :calories 38
	     :proteins 2.5
	     :fats 0.2
	     :carbonhydrates 6.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1166
     }
     {:gname "Грашак зелени"
	     :calories 98
	     :proteins 6.7
	     :fats 0.4
	     :carbonhydrates 16.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1167
     }
     {:gname "Грашак суви"
	     :calories 339
	     :proteins 23.8
	     :fats 1.4
	     :carbonhydrates 55.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1168
     }
     {:gname "Келераба"
	     :calories 36
	     :proteins 2.5
	     :fats 0.2
	     :carbonhydrates 5.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1169
     }
     {:gname "Карфиол"
	     :calories 25
	     :proteins 2.4
	     :fats 0.2
	     :carbonhydrates 3.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1170
     }
     {:gname "Кељ"
	     :calories 24
	     :proteins 1.4
	     :fats 0.2
	     :carbonhydrates 4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1171
     }
     {:gname "Краставци"
	     :calories 12
	     :proteins 0.7
	     :fats 0.1
	     :carbonhydrates 2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1172
     }
     {:gname "Купус кисели"
	     :calories 15
	     :proteins 1.1
	     :fats 0.2
	     :carbonhydrates 2.3
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1173
     }
     {:gname "Купус свеж"
	     :calories 28
	     :proteins 1.7
	     :fats 0.2
	     :carbonhydrates 4.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1174
     }
     {:gname "Лук бели"
	     :calories 136
	     :proteins 6.8
	     :fats 0.1
	     :carbonhydrates 26.3
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1175
     }
     {:gname "Лук црни"
	     :calories 44
	     :proteins 1.3
	     :fats 0.1
	     :carbonhydrates 9.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1176
     }
     {:gname "Празилук"
	     :calories 41
	     :proteins 2.8
	     :fats 0.3
	     :carbonhydrates 6.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1177
     }
     {:gname "Пасуљ"
	     :calories 307
	     :proteins 23.7
	     :fats 1.7
	     :carbonhydrates 47.3
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1178
     }
     {:gname "Пашканат (зелен)"
	     :calories 74
	     :proteins 1.5
	     :fats 0.5
	     :carbonhydrates 18.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1179
     }
     {:gname "Першун"
	     :calories 49
	     :proteins 3.7
	     :fats 0.7
	     :carbonhydrates 6.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1180
     }
     {:gname "Паприка зелена"
	     :calories 25
	     :proteins 1.2
	     :fats 0.2
	     :carbonhydrates 4.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1181
     }
     {:gname "Паприка црвена"
	     :calories 28
	     :proteins 1.2
	     :fats 0.2
	     :carbonhydrates 5.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1182
     }
     {:gname "Паприка кисела"
	     :calories 25
	     :proteins 1.2
	     :fats 0.2
	     :carbonhydrates 4.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1183
     }
     {:gname "Парадајз свеж"
	     :calories 20
	     :proteins 1
	     :fats 0.3
	     :carbonhydrates 3.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1184
     }
     {:gname "Парадајз кувани"
	     :calories 36
	     :proteins 1.8
	     :fats 0.5
	     :carbonhydrates 5.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1185
     }
     {:gname "Печурке свеже"
	     :calories 33
	     :proteins 4.9
	     :fats 0.2
	     :carbonhydrates 2.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1186
     }
     {:gname "Печурке суве"
	     :calories 313
	     :proteins 41.7
	     :fats 1.7
	     :carbonhydrates 30.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1187
     }
     {:gname "Ротквице"
	     :calories 43
	     :proteins 1.9
	     :fats 0.1
	     :carbonhydrates 8.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1188
     }
     {:gname "Сочиво"
	     :calories 337
	     :proteins 25
	     :fats 1
	     :carbonhydrates 54.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1189
     }
     {:gname "Спанаћ"
	     :calories 20
	     :proteins 2.3
	     :fats 0.3
	     :carbonhydrates 1.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1190
     }
     {:gname "Салата зелена"
	     :calories 18
	     :proteins 1.8
	     :fats 0.2
	     :carbonhydrates 37.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1191
     }
     {:gname "Хрен"
	     :calories 9
	     :proteins 0.3
	     :fats 0
	     :carbonhydrates 1.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1192
     }
     {:gname "Целер"
	     :calories 22
	     :proteins 1.3
	     :fats 0.2
	     :carbonhydrates 3.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1193
     }
     {:gname "Цвекла"
	     :calories 34
	     :proteins 1.3
	     :fats 0.1
	     :carbonhydrates 6.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1194
     }
     {:gname "Шаргарепа"
	     :calories 45
	     :proteins 1.2
	     :fats 0.3
	     :carbonhydrates 9.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1195
     }
     {:gname "Шпаргла"
	     :calories 19
	     :proteins 2
	     :fats 0.1
	     :carbonhydrates 2.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1196
     }
     {:gname "Тиквице"
	     :calories 31
	     :proteins 1.2
	     :fats 3
	     :carbonhydrates 5.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1197
     }
     {:gname "Ананас"
	     :calories 52
	     :proteins 0.4
	     :fats 0.2
	     :carbonhydrates 13.7
	     :description "Извор података\nВелики народни кувар"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1198
	     :diet "vegetarian"
     }
     {:gname "Брескве"
	     :calories 56
	     :proteins 0.5
	     :fats 0.1
	     :carbonhydrates 12
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1199
     }
     {:gname "Бадем суви"
	     :calories 596
	     :proteins 18.6
	     :fats 54.1
	     :carbonhydrates 4.3
	     :description "Извор података\nВелики народни кувар"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1200
	     :diet "vegetarian"
     }
     {:gname "Боровнице"
	     :calories 61
	     :proteins 0.6
	     :fats 0.6
	     :carbonhydrates 12.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1201
     }
     {:gname "Бруснице"
	     :calories 36
	     :proteins 1.3
	     :fats 0
	     :carbonhydrates 7.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1202
     }
     {:gname "Банане"
	     :calories 88
	     :proteins 1.2
	     :fats 0.2
	     :carbonhydrates 19.8
	     :description "Извор података\nВелики народни кувар"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1203
	     :diet "vegetarian"
     }
     {:gname "Грожђе"
	     :calories 62
	     :proteins 0.7
	     :fats 0.4
	     :carbonhydrates 13.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1204
     }
     {:gname "Грапе"
	     :calories 25
	     :proteins 0.4
	     :fats 0.1
	     :carbonhydrates 5.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1205
     }
     {:gname "Диња"
	     :calories 30
	     :proteins 0.8
	     :fats 0.1
	     :carbonhydrates 6.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1206
     }
     {:gname "Дуње"
	     :calories 45
	     :proteins 0.5
	     :fats 0.2
	     :carbonhydrates 10.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1207
     }
     {:gname "Јабуке"
	     :calories 58
	     :proteins 0.3
	     :fats 0.4
	     :carbonhydrates 12.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1208
     }
     {:gname "Јагоде"
	     :calories 43
	     :proteins 1.3
	     :fats 0.5
	     :carbonhydrates 8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1209
     }
     {:gname "Кикирики"
	     :calories 559
	     :proteins 26.9
	     :fats 44.2
	     :carbonhydrates 23.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1210
     }
     {:gname "Кокосов орах"
	     :calories 559
	     :proteins 3.4
	     :fats 34.7
	     :carbonhydrates 14
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1211
     }
     {:gname "Крушке"
	     :calories 57
	     :proteins 0.4
	     :fats 0
	     :carbonhydrates 13.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1212
     }
     {:gname "Кајсије"
	     :calories 51
	     :proteins 1
	     :fats 0.1
	     :carbonhydrates 11.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1213
     }
     {:gname "Кестен свеж"
	     :calories 168
	     :proteins 2.7
	     :fats 1.5
	     :carbonhydrates 24.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1214
     }
     {:gname "Купине"
	     :calories 57
	     :proteins 1.2
	     :fats 1
	     :carbonhydrates 10.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1215
     }
     {:gname "Лубенице"
	     :calories 28
	     :proteins 0.5
	     :fats 0.2
	     :carbonhydrates 5.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1216
     }
     {:gname "Лешник"
	     :calories 599
	     :proteins 12
	     :fats 56.5
	     :carbonhydrates 6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1217
     }
     {:gname "Лимун"
	     :calories 32
	     :proteins 0.9
	     :fats 0.6
	     :carbonhydrates 5.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1218
     }
     {:gname "Малине"
	     :calories 33
	     :proteins 1.4
	     :fats 0.6
	     :carbonhydrates 6.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1219
     }
     {:gname "Ораси (без љуске)"
	     :calories 580
	     :proteins 11.5
	     :fats 52.5
	     :carbonhydrates 11
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1220
     }
     {:gname "Огрозд"
	     :calories 55
	     :proteins 1.2
	     :fats 0.2
	     :carbonhydrates 11.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1221
     }
     {:gname "Поморанџе"
	     :calories 45
	     :proteins 0.9
	     :fats 0.2
	     :carbonhydrates 9.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1222
     }
     {:gname "Рибизле"
	     :calories 58
	     :proteins 1.4
	     :fats 0.4
	     :carbonhydrates 11.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1223
     }
     {:gname "Рошчићи"
	     :calories 316
	     :proteins 5.7
	     :fats 1.1
	     :carbonhydrates 69
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1224
     }
     {:gname "Трешње"
	     :calories 66
	     :proteins 1.1
	     :fats 0.5
	     :carbonhydrates 12.6
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1225
     }
     {:gname "Смокве свеже"
	     :calories 77
	     :proteins 1.4
	     :fats 0
	     :carbonhydrates 17.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1226
     }
     {:gname "Смокве суве"
	     :calories 254
	     :proteins 3.3
	     :fats 0
	     :carbonhydrates 58.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1227
     }
     {:gname "Шљиве свеже"
	     :calories 72
	     :proteins 0.8
	     :fats 0
	     :carbonhydrates 16.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1228
     }
     {:gname "Шљиве суве"
	     :calories 268
	     :proteins 2.3
	     :fats 0.6
	     :carbonhydrates 61.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1229
     }
     {:gname "Шипак"
	     :calories 129
	     :proteins 4.1
	     :fats 3
	     :carbonhydrates 25
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1230
     }
     {:gname "Урме"
	     :calories 284
	     :proteins 2.2
	     :fats 0.6
	     :carbonhydrates 65.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1231
     }
     {:gname "Грожђе суво"
	     :calories 289
	     :proteins 1.6
	     :fats 1.2
	     :carbonhydrates 66.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1232
     }
     {:gname "Шећер"
	     :calories 400
	     :proteins 0
	     :fats 0
	     :carbonhydrates 97.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1233
     }
     {:gname "Мармелада џем"
	     :calories 274
	     :proteins 0.5
	     :fats 0.3
	     :carbonhydrates 65.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1234
     }
     {:gname "Пекмез"
	     :calories 230
	     :proteins 1.5
	     :fats 0
	     :carbonhydrates 54.8
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1235
     }
     {:gname "Мед"
	     :calories 332
	     :proteins 0
	     :fats 0
	     :carbonhydrates 81
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1236
     }
     {:gname "Чоколада млечна"
	     :calories 575
	     :proteins 8.9
	     :fats 34.5
	     :carbonhydrates 53.1
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1237
     }
     {:gname "Чоколада за кување"
	     :calories 534
	     :proteins 6.5
	     :fats 27.5
	     :carbonhydrates 61.5
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1238
     }
     {:gname "Чоколада са лешником"
	     :calories 556
	     :proteins 9.4
	     :fats 46.2
	     :carbonhydrates 23.7
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1239
     }
     {:gname "Какао"
	     :calories 293
	     :proteins 8
	     :fats 23.8
	     :carbonhydrates 9.4
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1240
     }
     {:gname "Бомбоне чоколадне"
	     :calories 451
	     :proteins 3
	     :fats 15
	     :carbonhydrates 73
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1241
     }
     {:gname "Бомбоне воћне"
	     :calories 339
	     :proteins 0.3
	     :fats 0.1
	     :carbonhydrates 96.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1242
     }
     {:gname "Воћни сок са шећером"
	     :calories 81
	     :proteins 0.5
	     :fats 0.2
	     :carbonhydrates 19
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1243
     }
     {:gname "Малинов сируп"
	     :calories 283
	     :proteins 0.1
	     :fats 0
	     :carbonhydrates 68.9
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1244
     }
     {:gname "Ракија (25% алкохола)"
	     :calories 175
	     :proteins 0
	     :fats 0
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1245
     }
     {:gname "Вино (10% алкохола)"
	     :calories 70
	     :proteins 0
	     :fats 0
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1246
     }
     {:gname "Пиво (4% алкохола)"
	     :calories 49
	     :proteins 0
	     :fats 0
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1247
     }
     {:gname "Коњак (50% алкохола)"
	     :calories 375
	     :proteins 0
	     :fats 0
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1248
     }
     {:gname "Рум (40% алкохола)"
	     :calories 280
	     :proteins 0
	     :fats 0
	     :carbonhydrates 0
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_vii"
	     ]
	     :label-code 1249
     }
     {:gname "Маслине"
	     :calories 138
	     :proteins 1.1
	     :fats 14.8
	     :carbonhydrates 0.3
	     :description "Извор података\nDeleco - Маслине\nЗелене стоне\nбез коштице"
	     :diet "vegetarian"
	     :group [
		     "group_vi"
	     ]
	     :label-code 1250
     }
     {:gname "Кечап благи"
	     :calories 77
	     :proteins 1.1
	     :fats 0.1
	     :carbonhydrates 17.8
	     :description "Извор података\nPolimark ketchup blagi"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1251
     }
     {:gname "Кечап пица и паста"
	     :calories 77
	     :proteins 1.1
	     :fats 0.1
	     :carbonhydrates 18
	     :description "Извор података\nPolimark kechup pizza & pasta"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1252
     }
     {:gname "Артичока"
	     :calories 24
	     :proteins 1.4
	     :fats 0.1
	     :carbonhydrates 4.2
	     :description "Извор података\nВелики народни кувар"
	     :diet "vegetarian"
	     :group [
		     "group_v"
	     ]
	     :label-code 1253
     }
     {:description "Извор података\nВелики народни кувар"
	     :calories 87
	     :group [
		     "group_v"
	     ]
	     :label-code 1254
	     :carbonhydrates 19.1
	     :gname "Кромпир свеж"
	     :fats 0.1
	     :proteins 2
	     :diet "vegetarian"
     }
     {:description "Извор података\nВелики народни кувар"
	     :calories 304
	     :group [
		     "group_v"
	     ]
	     :label-code 1255
	     :carbonhydrates 61.4
	     :gname "Кромпир суви"
	     :fats 1.5
	     :proteins 9.3
	     :diet "vegetarian"
     }
     {:description "ИзворАмбалажа кукурузних пахуљица"
	     :calories 370
	     :group [
		     "group_i"
	     ]
	     :label-code 1256
	     :carbonhydrates 82.7
	     :gname "Кукурузне пахуљице"
	     :fats 0.5
	     :proteins 6.6
	     :diet "vegetarian"
     }
     {:description "ИзворАмбалажа двопека са белим луком"
	     :calories 447
	     :group [
		     "group_i"
	     ]
	     :label-code 1257
	     :carbonhydrates 62
	     :gname "Двопек са белим луком"
	     :fats 15
	     :proteins 14
	     :diet "vegetarian"
     }
     {:description "ИзворАмбалажа за двопек са укусом пице"
	     :calories 459
	     :group [
		     "group_i"
	     ]
	     :label-code 1258
	     :carbonhydrates 66
	     :gname "Двопек са укусом пице"
	     :fats 15
	     :proteins 13
	     :diet "vegetarian"
     }
     {:description "ИзворАмбалажа за двопек са укусом сланине"
	     :calories 463
	     :group [
		     "group_i"
	     ]
	     :label-code 1259
	     :carbonhydrates 67
	     :gname "Двопек са укусом сланине"
	     :fats 15
	     :proteins 13
	     :diet "not_vegetarian"
     }]))

