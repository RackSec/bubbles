(ns bubbles.xml-test
  (:require [bubbles.xml :as bx]
            [bubbles.test-macros :refer-macros [defsample]]
            [cljs.test :refer-macros [deftest]]))

(defsample soap-request
  "test/SOAPRequest.xml")

(defsample soap-response
  "test/SOAPResponse.xml")
