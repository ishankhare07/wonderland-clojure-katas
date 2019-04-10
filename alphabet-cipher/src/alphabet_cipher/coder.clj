(ns alphabet-cipher.coder
  (:use [clojure.string :only [index-of]]))

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

(defn encode [keyword message]
  (apply str (map encrypt (cycle keyword) message)))

(defn decode [keyword message]
  (apply str (map decrypt (cycle keyword) message)))

(defn decipher [cipher message]
  "decypherme")
