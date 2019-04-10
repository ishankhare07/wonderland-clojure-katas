(ns alphabet-cipher.coder
  (:use [clojure.string :only [index-of]]))

(defn char-map []
  (map char (range 97 (+ 97 26))))

(defn cipher [m k]
  (let [chars (apply str (char-map))
        mx (index-of chars m)
        kx (index-of chars k)
        r (+ mx kx)]
    (if (< r 26)
      (nth chars r)
      (do
        (nth chars (rem r 26))))))

(defn encode [keyword message]
  (apply str (map cipher (cycle keyword) message)))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
