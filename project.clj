(defproject org.vladimir/personal-organiser-server "0.1.0"
  :description "Personal organiser server"
  :url "http://gitlab:1610/VladimirMarkovic86/personal-organiser-server"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.vladimir/server-lib "0.1.0"]
                 [org.vladimir/mongo-lib "0.1.0"]
                 [org.vladimir/ajax-lib "0.1.0"]
                 [org.vladimir/session-lib "0.1.0"]
                 [org.vladimir/common-server "0.1.0"]
                 ]

  ; AOT - Compailation ahead of time
  :main ^:skip-aot personal-organiser-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :repl-options {:port 8601})

