(ns alphabet-cipher.coder)

(defn shift
  [k m]
  (let [char-case 97
        after-shift (+ (int m) (- (int k) char-case))]
    (if (>= after-shift (+ char-case 26))
      (char (- (int k) (- (+ char-case 26) (int m))))
      (char after-shift))))

(defn encode [keyword message]
  (apply str (map shift (cycle keyword) message)))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

(apply str (map shift "apple" "mango"))
