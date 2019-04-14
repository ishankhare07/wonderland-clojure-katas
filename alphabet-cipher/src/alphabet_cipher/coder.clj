(ns alphabet-cipher.coder
  (:use [clojure.string :only [index-of]]
        [clojure.math.numeric-tower :only [abs]]))

(defn char-map []
  (map char (range 97 (+ 97 26))))

(defn encrypt [m k]
  (let [chars (apply str (char-map))
        mx (index-of chars m)
        kx (index-of chars k)
        c (+ mx kx)]
    (if (< c 26)
      (nth chars c)
      (do
        (nth chars (rem c 26))))))

(defn decrypt [k c]
  (let [chars (apply str (char-map))
        kx (index-of chars k)
        cx (index-of chars c)
        m (- cx kx)]
    (if (< m 0)
      (nth chars (+ 26 m))
      (nth chars m))))

(defn retrieve [c m]
  (let [chars (apply str (char-map))
        cx (index-of chars c)
        mx (index-of chars m)
        k (- cx mx)]
    (if (< k 0)
      (nth chars (+ 26 k))
      (nth chars k))))

(defn encode [keyword message]
  (apply str (map encrypt (cycle keyword) message)))

(defn decode [keyword message]
  (apply str (map decrypt (cycle keyword) message)))

(defn reduce-repeat
  [current-key reduced-key]
  (println current-key reduced-key)
  (let [m (first (re-seq #"(.+)\1" current-key))]
    (if (= (last m) nil)
      (do
        (println m reduced-key)
        current-key)
      (reduce-repeat (last m) (first m)))))

(defn decipher [cipher message]
  (reduce-repeat (apply str (map retrieve cipher message)) nil))
