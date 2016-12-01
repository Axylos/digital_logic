(ns advent07.core-test
(:require [clojure.test :refer :all]
          [advent07.signal-parser :as sig :refer :all])
  (:import [advent07.signal_parser Sig]))

(deftest a-test
  (testing "failure"
    (is (= 0 0))))

(deftest sig-parse-test
  (testing "sig parse reads a line and returns a record"
    (is (= (instance? Sig (sig-parse "0 -> c")) true)))
  (testing "sig parse parses concrete value"
    (is (= (Sig. :VALUE [] 0 :c) (sig-parse "0 -> c"))))
  (testing "parses not op"
    (is (= (Sig. :NOT [4] nil :d) (sig-parse"NOT 4 -> d"))))
  (testing "parses OR op"
    (is (= (Sig. :OR [1 2] nil :e) (sig-parse"1 OR 2 -> e"))))
  (testing "parses LSHIFT op"
    (is (= (Sig. :LSHIFT [:bl 3] nil :f) (sig-parse "bl LSHIFT 3 -> f"))))
  (testing "parses a reference"
    (is (= (Sig. :RSHIFT [:ai 9] nil :e) (sig-parse "ai RSHIFT 9 -> e")))))

(deftest op-parse-test
  (testing "parse operation from string"
    (is (= (op-parse "NOT 4 -> c") :NOT)))
  (testing "parses a value"
    (is (= :VALUE (op-parse "0 -> d")))))
                            

