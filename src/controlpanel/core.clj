(ns controlpanel.core
  (:use [controlpanel.panel]
        [controlpanel.service])
  (:gen-class))

(defn -main [& args]
  (menu-infinite!
    (menu-maker
      ["hello" #(println "Hello")]
      ["test" #(println "test")]
      ["Service" #(service-select!)]
      ["exit" #(exit!)])))