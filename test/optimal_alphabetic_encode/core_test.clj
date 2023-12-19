(ns optimal-alphabetic-encode.core-test
  (:require [midje.sweet :refer :all]
            [optimal-alphabetic-encode.core :refer :all]))

(fact "Convert string to array of characters"
      (string-to-array "MARIBOR") => [\M \A \R \I \B \O]
      (string-to-array "") => []
      (string-to-array "BEOGRAD") => [\B \E \O \G \R \A \D])

(fact "Length of array"
      (length-array [\B \E \O \G \R \A \D])=> (long 7)
      (length-array [\A \I \E \O])=> (long 4)
      (length-array [])=> (long 0)
      (length-array (string-to-array "MARUBOR"))=> (long 6)
      (length-array (string-to-array "NIS"))=> (long 3)
      (length-array (string-to-array ""))=> (long 0))


