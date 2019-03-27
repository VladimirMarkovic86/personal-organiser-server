(defproject org.clojars.vladimirmarkovic86/personal-organiser-server "0.2.1"
  :description "Personal organiser server"
  :url "http://github.com/VladimirMarkovic86/personal-organiser-server"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojars.vladimirmarkovic86/server-lib "0.3.23"]
                 [org.clojars.vladimirmarkovic86/mongo-lib "0.2.5"]
                 [org.clojars.vladimirmarkovic86/ajax-lib "0.1.8"]
                 [org.clojars.vladimirmarkovic86/session-lib "0.2.14"]
                 [org.clojars.vladimirmarkovic86/common-server "0.3.24"]
                 [org.clojars.vladimirmarkovic86/personal-organiser-middle "0.2.6"]
                 [org.clojars.vladimirmarkovic86/common-middle "0.2.5"]
                 [org.clojars.vladimirmarkovic86/utils-lib "0.4.7"]
                 [org.clojars.vladimirmarkovic86/audit-lib "0.1.20"]
                 [org.clojars.vladimirmarkovic86/personal-organiser-lib "0.1.2"]
                 ]

  :min-lein-version "2.0.0"

  :source-paths ["src/clj"]
  
  :main ^:skip-aot personal-organiser-server.core
  
  :uberjar-name "personal-organiser-server-standalone.jar"
  :profiles {:uberjar {:aot :all}}
  :repl-options {:port 8601})

