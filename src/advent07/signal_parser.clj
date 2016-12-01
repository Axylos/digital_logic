(ns advent07.signal-parser
  (:require [clojure.string :as str :refer :all]))


(defrecord Sig [op args value])

(defn split-line [line]
  (str/split line #" "))

(comment 
(defmulti sig-parse (fn[op]))
(defn sig-parse []
  (Sig. )))

(defn sig-parse [signal]
  (Sig. 1 2 3))

(defn op-parse [string]
  (let [op (re-find #"[A-Z]+" string)]
    (if (nil? op)
      :VALUE
      (keyword op))))
