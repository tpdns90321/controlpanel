(defproject controlpanel "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://tpdns.xyz"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [cheshire "5.6.1"]]
  :main controlpanel.core
  :aot [controlpanel.core
       controlpanel.panel
       controlpanel.service]
  :resource-paths ["resources"])
