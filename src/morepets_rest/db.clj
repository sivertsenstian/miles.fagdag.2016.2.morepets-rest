(ns morepets-rest.db
 (:require [clojure.string :as str])
 (:use [korma.db]
       [korma.core]))

(defdb milesdb {:classname "org.sqlite.JDBC"
                :subprotocol "sqlite"
                :subname "db/dev.sqlite3"})

;;Entities
;;pet
(declare pets id name gender url)
(defentity pets)

(defn get-pets [] (select pets))

(defn get-pet [id]
 (->
  (select* pets)
  (where (= :id id))
  (exec)))

(defn create-pet [name gender url]
  (insert pets
   (values {:name name
            :gender gender
            :url url})))

;;robot
(declare robots id name color ipaddress url)
(defentity robots)

(defn get-robots [] (select robots))

(defn get-robot [id]
  (-> 
    (select* robots)
    (where {:id id})
    (exec)))