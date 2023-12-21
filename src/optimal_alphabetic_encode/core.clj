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

(defn letter-count-array ^ints [letter-map]
  (vals letter-map))

(defn probability ^doubles [^ints array ^long n]
  (amap array i  ret (/ (aget array i) n)))
(defn probability-v1 ^doubles [^ints array ^long n]
  (let [result (double-array (count array))]
    (amap ^ints array i [result]  (/ (aget array i) n))
    result))

(defn probability-v2 ^doubles [^ints array ^long n]
  (let [result (double-array (count array))]
    (loop [i 0]
      (when (< i (count array))
        (aset result i (double (/ (aget array i) n)))
        (recur (inc i))))
    result))




