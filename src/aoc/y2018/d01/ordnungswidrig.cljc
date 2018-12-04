(ns aoc.y2018.d01.ordnungswidrig
  (:refer-clojure :exclude [read-string format])
  (:require
   [aoc.utils :as u :refer [deftest read-string format]]
   [aoc.y2018.d01.data :refer [input answer-1 answer-2]]
   [clojure.string :as str]
   [clojure.test :refer [is testing]]))

(def data
  (->> input
       str/split-lines
       (map u/read-string)))


(defn solve-1 []
  (reduce + data))

(defn solve-2 []
  (->> data
       cycle
       (reductions +)
       (reduce (fn [s x] (if (contains? s x)
                           (reduced x)
                           (conj s x)))
               #{0})))

(deftest part-1
  (is (= (str answer-1)
         (str (solve-1)))))

(deftest part-2
  (is (= (str answer-2)
         (str (solve-2)))))
