(ns bubbles.xml
  "Fanciness related to parsing and serializing XML."
  (:require
   [hickory.core :as h]))

;; whitespace? & remove-whitespace were copied from crunch and
;; submitted for consideration to upstream hickory:
;; https://github.com/davidsantiago/hickory/issues/28

(def ^:private whitespace?
  "Is this a string, and does it consist of only whitespace?"
  (every-pred string? (partial re-matches #"\s*")))

(defn ^:private remove-whitespace
  "Walk a given Hiccup form and remove all pure whitespace."
  [row]
  (walk/prewalk
   (fn [form]
     (if (vector? form)
       (into [] (remove whitespace? form))
       form))
   row))

(defn parse-xml
  "Parse an XML string into DOM objects.

  TODO: consider submitting this upstream to Hickory; maybe give
  parse-dom-with-domparser an optional doctype arg."
  [s]
  (.parseFromString (js/DOMParser.) s "text/xml"))

(defn ->xml
  "Turns a Clojure data structure into some XML."
  [data]
  )
