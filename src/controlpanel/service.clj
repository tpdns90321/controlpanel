(ns controlpanel.service
    (:require [clojure.java.io :as io]
              [controlpanel.panel :as panel]
              [cheshire.core :refer :all])
    (:use [clojure.java.shell :only [sh]]))

(def service-command-file
    (-> "service-command.conf" io/resource io/reader))

(def services ["nginx"])

(def service-commands (parse-stream service-command-file))

(defn get-command [state]
    (get service-commands state))

(defn service-state-change! [name state]
    (panel/run-command! (format (get-command state) name)))

(defn service-select! []
    (panel/menu!
        (for [n services]
            [n #(panel/menu!
                    (for [st '("stop" "start")]
                        [(format "%s %s" st n) (fn [] (service-state-change! n st))]))])))