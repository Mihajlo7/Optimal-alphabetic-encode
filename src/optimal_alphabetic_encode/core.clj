(ns optimal-alphabetic-encode.core)

(set! *unchecked-math* :warn-on-boxed)
(set! *warn-on-reflection* true)

(def rec "MARIBOR")

(defn string-to-array ^chars [^String rec]
  (vec (distinct rec))
  )

(defn length-array ^long [^chars array]
  (count array)
  )
