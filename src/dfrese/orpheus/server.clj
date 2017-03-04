(ns dfrese.orpheus.server
  (:require [dfrese.orpheus.core :as core]
            [dfrese.orpheus.patch.base :as pbase]
            [dfrese.edomus.core :as dom]
            [dfrese.edomus.virtual :as dom-server]
            [hiccup.core :as hiccup]
            [hiccup.page :as hiccup-page]))

(defn vdom->hiccup [vdom]
  (let [doc (dom-server/new-document)]
    (dom-server/to-hiccup (pbase/create-child doc vdom {}))))

(defn hiccup->page [head body]
  (hiccup-page/html5 {:xml? false} head body))

(defn- default-wrapper [e]
  [:body e])

(defn vdom->page [vdom & [head wrap-body]]
  (let [wrap (or wrap-body default-wrapper)]
    (hiccup->page (or head [:head])
                  (-> vdom
                      vdom->hiccup
                      wrap))))
