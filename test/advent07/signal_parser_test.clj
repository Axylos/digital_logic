(ns advent07.core-test
(:require [clojure.test :refer :all]
          [advent07.signal-parser :as sig :refer :all])
  (:import [advent07.signal_parser Sig]))

(deftest a-test
  (testing "failure"
    (is (= 0 0))))

(deftest sig-parse-test
  (testing "sig parse reads a line and returns a record"
    (is (= (instance? Sig (sig-parse "0 -> c")) true))))

(deftest op-parse-test
  (testing "parse operation from string"
    (is (= (op-parse "NOT 4 -> c") :NOT)))
  (testing "parses a value"
    (is (= :VALUE (op-parse "0 -> d")))))
                            

