(ns bubbles.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [bubbles.core-test]
            [bubbles.xml-test]))

(doo-tests 'bubbles.core-test
           'bubbles.xml-test)
