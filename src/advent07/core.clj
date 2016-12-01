(ns advent07.core
(:require
  [clojure.java.io :as io]
  [clojure.string :as str]
  [advent07.signal-parser :as signal-parser :refer :all]
  ))

;;(.getfile (clojure.java.io/resource "advent07_data.txt"))

(def data (io/file (clojure.java.io/resource "advent07_data.txt")))
(def sig_data {})
(with-open [rdr (io/reader data)]
  (map signal-parser/sig-parse (line-seq rdr))
  (def line-data (line-seq rdr)))
