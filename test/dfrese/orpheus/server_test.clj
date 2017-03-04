(ns dfrese.orpheus.server-test
  (:require [clojure.test :refer [deftest is testing]]
            [dfrese.orpheus.server :as server]
            [dfrese.orpheus.core :as core]
            [dfrese.orpheus.html :as html]))

(deftest vdom->page-test
  (let [wrap (fn [s]
               (str "<!DOCTYPE html>\n<html><head></head><body>" s "</body></html>"))]
    (is (= (wrap "<div></div>")
           (server/vdom->page (html/div))))
    (is (= (wrap "<div align=\"top\" class=\"test\">Hello World</div>")
           (server/vdom->page (html/div {:className "test"
                                           ;; :tabIndex 2 - not defined?
                                           :align "top"}
                                          "Hello World"))))
    (is (= (wrap "<div><span>Hello World</span></div>")
           (server/vdom->page (html/div (html/span "Hello World")))))
    (is (= (wrap "<div style=\"padding-top: 1\"></div>")
           (server/vdom->page (html/div {:style {"padding-top" 1}}))))))
