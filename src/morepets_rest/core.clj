(ns morepets-rest.core
 (:require [morepets-rest.db :as mp-db]
           [morepets-rest.handler :as mp-rest]))
           ; [korma.db :as kdb]
           ; [korma.core :as kc]))

;(declare pets id name gender url)

(defn main
 (mp-rest/app))

 ; (do
 ;  (kdb/defdb milesdb {:classname "org.sqlite.JDBC"
 ;                      :subprotocol "sqlite"
 ;                      :subname "db/dev.sqlite3"})
 ;  ;;Entities
 ;  (kc/defentity pets)
 ;  (mp-rest/app)
