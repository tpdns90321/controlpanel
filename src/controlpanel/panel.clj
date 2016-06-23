(ns controlpanel.panel
  (:use [clojure.java.shell :only [sh]]
        [clojure.string :only [join]]))

(defn menu-maker [& lst]
  (for [l lst]
    l))

(defn selectnum! [f]
  (try (f (Integer. (read-line)))
    (catch Exception e
      (let []
        (println e)
        false))))

(defn run-function [n lst limit]
  (if (not (or (= n 0) (> n limit)))
    (do ((second (nth lst (- n 1)))))
    false))

(defn menu! [lst]
  (let [i (atom 0)]
    (doseq [l lst]
      (println (swap! i + 1) (first l)))
    (println "Select Number (1~) (other number exit)")
    (selectnum! #(run-function % lst @i))))

(defn menu-infinite! [lst]
  (while (not (false? (menu! lst)))))

(defn run-command! [com]
  (try (sh (join " " (rest (first (re-seq #"(\S+)\s?" com)))))
      (catch Exception e (println "Can't Run Command"))))

(defn exit! []
  (System/exit 0))

(defn menu-exit [] false)