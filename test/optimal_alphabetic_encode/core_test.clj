(ns optimal-alphabetic-encode.core-test
  (:require [midje.sweet :refer :all]
            [optimal-alphabetic-encode.core :refer :all]))


(facts "From String to Chars"
       (string-to-array "MARIBOR")=> [\M \A \R \I \B \O]
       (string-to-array "")=> ""
       (string-to-array "BEOGRAD")=> [\B \E \O \G \R \A \D])