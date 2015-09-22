(ns bubbles.test-macros
  (:require
   [clojure.java.io :as io]))

(def om-nom-nom
  (comp slurp io/resource))

(defmacro om-nom-nom*
  "Macrify om-nom-nom so that it will be run in Clojure, at compile
  time, giving Clojurescript access to io/resource."
  [sample]
  (om-nom-nom sample))

(defmacro defsample
  [name sample]
  `(def ~name ~(om-nom-nom sample)))
