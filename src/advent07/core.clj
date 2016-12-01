(ns advent07.core
(:require
  [clojure.java.io :as io]
  [clojure.string :as str]
  ))

;;(.getfile (clojure.java.io/resource "advent07_data.txt"))

(def data (io/file (clojure.java.io/resource "advent07_data.txt")))
(def sig_data {})
(with-open [rdr (io/reader data)]
  (def line_data (line-seq rdr)))

(last '(1 2 3 4))
(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
