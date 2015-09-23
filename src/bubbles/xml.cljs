(ns bubbles.xml
  "Fanciness related to parsing and serializing XML."
  (:require
   [hickory.core :as h]))

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
