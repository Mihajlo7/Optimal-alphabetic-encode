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

(defn letter-count  [^String text]
  (reduce
    (fn [counts char]
      (update counts char (fnil inc 0)))
    {}
    text)
  )
