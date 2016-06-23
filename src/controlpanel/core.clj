(ns controlpanel.core
  (:use [controlpanel.panel]
        [controlpanel.service])
  (:gen-class))

(defn -main [& args]
  (menu-infinite!
    (menu-maker
      ["Service" #(service-select!)]
      ["exit" #(System/exit 0)])))