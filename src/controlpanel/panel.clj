(ns controlpanel.panel
  (:use [clojure.java.shell :only [sh]]
        [clojure.string :only [join]]))

(defn menu-maker [& lst]
  (for [l lst]
    l))

(defn selectnum! [^clojure.lang.AFunction f]
  (try (f (Integer. (read-line)))
    (catch java.lang.NumberFormatException _
      (let []
        (println "Wrong Number")
        true))))

(defn run-second-function [^Long n ^clojure.lang.IPersistentCollection lst ^Long limit]
  (if (not (or (= n 0) (> n limit)))
    ((second (nth lst (- n 1))))
    true))

(defn menu! [^clojure.lang.IPersistentCollection lst]
  (let [i (atom 0)]
    (doseq [l lst]
      (println (swap! i + 1) (first l)))
    (println "Select Number (1~) (other number exit)")
    (selectnum! #(run-second-function % lst @i))))

(defn menu-infinite! [^clojure.lang.IPersistentCollection lst]
  (while (not (false? (menu! lst)))))

(defn run-command! [^String com]
  (try (apply sh (for [res (re-seq #"(\S+)\s?" com)]
                    (second res)))
      (catch java.io.IOException e (println "Can't Run Command"))))