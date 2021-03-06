(ns bubbles.xml
  "Fanciness related to parsing and serializing XML."
  (:require
   [clojure.walk :as walk]
   [hickory.core :as h]
   [clojure.browser.dom :as cdom]
   [goog.dom.xml :as gxml]
   [taoensso.timbre :refer-macros [info spy]]))

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

(defn ^:private parse-xml
  "Parse an XML string into DOM objects.

  TODO: consider submitting this upstream to Hickory; maybe give
  parse-dom-with-domparser an optional doctype arg."
  [xml-string]
  (.parseFromString (js/DOMParser.) xml-string "text/xml"))

(defn ^:private maybe-parse-xml
  "If passed a string, parse as XML; if Document, return verbatim,
  otherwise; raise an exception."
  [string-or-document]
  (cond
    (string? string-or-document) (parse-xml string-or-document)
    (instance? js/Document string-or-document) string-or-document))

(def xml->
  "Parse an XML string or document into a usable Hiccup Clojure data
  structure."
  (comp remove-whitespace h/as-hiccup maybe-parse-xml))

(defn ->xml-structure
  [])

(defn xml-struct->xml-doc
  "Turns a Clojure Hiccup-style data structure representing an XML
  document into an actual XML document."
  [data]
  (let [doc (gxml/createDocument)]
    (walk/postwalk
     (fn [elem]
       (info elem)
       (cond
         (vector? elem)
         (let [[tag attrs & children] elem
               node (.createElement doc)]
           (apply cdom/append node children))

         (string? elem)
         (.createTextNode doc elem)

         :else elem)) ;; keyword (tag) or map (attrs); pass
     data)))
