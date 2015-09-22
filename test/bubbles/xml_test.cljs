(ns bubbles.xml-test
  (:require
   [bubbles.xml :as bx]
   [cljs.test :refer-macros [deftest testing is are]])
  (:require-macros
   [bubbles.test-macros :as t]))

(t/defsample soap-request
  "test/SOAPRequest.xml")

(t/defsample soap-response
  "test/SOAPResponse.xml")

(deftest parse-xml
  (is (= (bx/parse-xml soap-request)
         [])))
