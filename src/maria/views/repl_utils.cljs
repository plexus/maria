(ns maria.views.repl-utils
  (:require [re-view.core :as v :refer [defview]]))

(def card-classes "mh3 mv2 shadow-4 bg-white pv1")

(v/defn card
  {:spec/props {:spec/keys []}
   :spec/children []}
  [& items]
  (into [:div {:class card-classes}] items))

(v/defn plain [& items]
  (into [:.mh3] items))

(defn scroll-bottom [component]
  (let [el (v/dom-node component)]
    (set! (.-scrollTop el) (.-scrollHeight el))))

(defview ScrollBottom
         {:life/did-update scroll-bottom
          :life/did-mount  scroll-bottom}
         [_ element]
         element)