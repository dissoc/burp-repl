(defproject burp-repl "0.1.0-SNAPSHOT"
  :description "everything required to repl into burp suite."
  :license {:name "Apache License Version 2.0"
            :url  "https://www.apache.org/licenses/LICENSE-2.0.txt"}
  :dependencies [[com.taoensso/timbre "6.3.1"]
                 [net.portswigger.burp.extensions/montoya-api "2023.12.1"]
                 [nrepl "1.1.0"]
                 [org.clojure/clojure "1.10.3"]]
  :java-source-paths ["java-src"]
  :plugins [[cider/cider-nrepl "0.45.0"]]
  :aot :all
  :repl-options {:init-ns burp-repl.core})
