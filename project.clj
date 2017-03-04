(defproject dfrese/orpheus-server "0.1.0-SNAPSHOT"
  :description "Library for generating html pages from orpheus virtual dom elements."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                 [dfrese/orpheus-core "0.1.0-SNAPSHOT"]
                 [dfrese/clj "0.1.0-SNAPSHOT"]
                 [dfrese/edomus "0.1.0-SNAPSHOT"]
                 [hiccup "1.0.5"]]

  :plugins [[lein-codox "0.10.1"]]

  :codox {:language :clojures
          :metadata {:doc/format :markdown}})
