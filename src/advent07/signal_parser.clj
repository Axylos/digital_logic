(ns advent07.signal-parser
  (:require [clojure.string :as str :refer :all]))


(defrecord Sig [op args signal node_name])

(defn split-line [line]
  (str/split line #" "))

(defn op-parse [string]
  (let [op (re-find #"[A-Z]+" string)]
    (if (nil? op)
      :VALUE
      (keyword op))))

(defn parse-signal-arg [arg]
  (if (instance? Long (read-string arg))
    (read-string arg)
    (keyword arg)))

(defn build-signal [op tokens]
    (Sig.
         op
         [(parse-signal-arg (first tokens)) (parse-signal-arg (get tokens 2))]
         nil
         (keyword (last tokens))))

(defn sig-parse
  "takes a string encoded signal in the form '0 -> c' or 'NOT 4 -> d' or 'c RSHIFT 5 -> e'
  can receive ops LSHIFT RSHIFT NOT AND OR and a concrete value"
  [signal]
  (let [
        op (op-parse signal)
        tokens (split-line signal)
        ]
    (cond
      (= :VALUE op) (Sig. op [] (read-string (first tokens)) (keyword (last tokens)))
      (= :NOT op) (Sig. op [(read-string (get tokens 1))] nil (keyword (last tokens)))
      (= :else) (build-signal op tokens))))
