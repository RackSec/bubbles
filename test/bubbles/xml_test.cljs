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
  (is (= (bx/xml-> soap-request)
         [[:soap:envelope
           {:xmlns:soap "http://www.w3.org/2001/12/soap-envelope",
            :soap:encodingstyle "http://www.w3.org/2001/12/soap-encoding"}
           [:soap:body
            {:xmlns:m "http://www.example.org/stock"}
            [:m:getstockprice {}
             [:m:stockname {} "RAX"]]]]]))
  (is (= (bx/xml-> soap-response)
         [[:soap:envelope
           {:xmlns:soap "http://www.w3.org/2001/12/soap-envelope",
            :soap:encodingstyle "http://www.w3.org/2001/12/soap-encoding"}
           [:soap:body
            {:xmlns:m "http://www.example.org/stock"}
            [:m:getstockpriceresponse {} [:m:price {} "34.5"]]]]])))
