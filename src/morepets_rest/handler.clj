(ns morepets-rest.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [ring.middleware.cors :refer [wrap-cors]]
            [ring.util.response :refer [response]]
            [clojure.string :as str]
            [korma.db :as kdb]
            [korma.core :as kc]
            [morepets-rest.db :as mpdb]))
;;REST
;;pets
(defn get-pets [] (response (mpdb/get-pets)))
(defn get-pet [id] (response (mpdb/get-pet id)))
(defn create-new-pet [{:keys [name gender url]}] (mpdb/create-pet name gender url))
(defn update-pet [id changes])
(defn delete-pet [id])

;;robots
(defn get-robots [] (response (mpdb/get-robots)))
(defn get-robot [id] (response (mpdb/get-robot id)))


;;routes
(defroutes app-routes
 (GET "/" [] "Hello miles!")
 (context "/pets" [] (defroutes pets-routes
                      (GET "/" [] (get-pets))
                      (POST "/" {:keys [params]} (create-new-pet params))
                      (context "/:id" [id] (defroutes pets-routes
                                            (GET "/" [] (get-pet id))
                                            (PUT "/" {body :body} (update-pet id body))
                                            (DELETE "/" [] (delete-pet id))))))
 
 (context "/robots" [] (defroutes robots-routes
                        (GET "/" [] (get-robots))
                        (context "/:id" [id] (defroutes robots-routes
                                              (GET "/" [] (get-robot id))))))
 (route/not-found "404 Not Found"))


;;Init
(def app
 (-> (handler/api app-routes)
     (wrap-cors #".*")
     (middleware/wrap-json-body)
     (middleware/wrap-json-response)
     (middleware/wrap-json-params)))
