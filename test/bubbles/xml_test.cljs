(ns bubbles.xml-test
  (:require
   [bubbles.xml :as bx]
   [hickory.core :as h])
  (:require-macros
   [cljs.test :refer [deftest is]]
   [bubbles.test-macros :as t]))

(t/defsample soap-request
  "test/SOAPRequest.xml")

(t/defsample soap-response
  "test/SOAPResponse.xml")

(deftest parse-xml
  (is (= (bx/parse-xml soap-request)
         [])))
