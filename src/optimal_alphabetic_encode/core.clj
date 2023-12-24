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

(defn optimal-encode [^doubles p ^long n]

  (let [c-array (double-array (inc n))
        g-matrix (make-array Double/TYPE (inc n) (inc n))
        h-matrix (make-array Integer/TYPE (inc n) (inc n))]
    ;; Initialization values
    (aset c-array 0 0.0)
    (loop [i 1]
      (when (<= i n)
        (aset g-matrix i i 0)
        (aset c-array  i (+ (aget c-array (dec i)) (aget p (dec i))))
        (recur (inc i))
        )
      )
    ;; Optimization all pairs

    c-array)
  )






