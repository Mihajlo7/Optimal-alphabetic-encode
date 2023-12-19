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

(fact "Tests for map of string"
      (letter-count "Danas")=> {\D 1 \a 2 \n 1 \s 1}
      (letter-count "Es ist regnet")=> {\E 1 \s 2 \space 2 \i 1 \t 2 \r 1 \g 1 \n 1 \e 2 }
      (letter-count "")=> {}
      (letter-count "-- - !")=> {\- 3 \space 2 \! 1}
      (letter-count "'My book'")= > {\M 1, \' 2, \y 1, \space 1, \b 1, \o 2, \k 1} )


