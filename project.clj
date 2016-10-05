(defproject morepets-rest "0.1.0-SNAPSHOT"
  ;:main morepets-rest.core
  :description "Aint nobody got time for that"
  :url "http://www.stianerbest.com"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]

                 [korma "0.4.0"]
                 [org.xerial/sqlite-jdbc "3.14.2"]
                 [ring/ring-json "0.4.0"]
                 [jumblerg/ring.middleware.cors "1.0.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler morepets-rest.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
