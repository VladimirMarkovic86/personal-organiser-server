(defproject personal-organiser-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure			   "1.8.0"]
         									;	https://clojure.org/api/api
         								[compojure													   "1.6.0"]
         									;	http://weavejester.github.io/compojure/
         								[ring/ring-core								   "1.6.3"]
         									;	https://ring-clojure.github.io/ring/index.html
         								[ring/ring-jetty-adapter	 "1.6.3"]
         									;	https://ring-clojure.github.io/ring/ring.adapter.jetty.html
         									;	[ring-cors "0.1.11"];https://github.com/r0man/ring-cors
         									;	[ring/ring-ssl "0.3.0"];https://github.com/ring-clojure/ring-ssl
         								[com.novemberain/monger "3.1.0"]
         								]
  
  ; AOT - Compailation ahead of time
  :main ^:skip-aot personal-organiser-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
