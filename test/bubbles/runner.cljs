(ns bubbles.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [bubbles.core-test]))

(doo-tests 'bubbles.core-test)
