(ns clojure-collections.aula2)

;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]

(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    (inc total-ate-agora)
    ))

(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta 0 []))


(defn conta
  
  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora elementos]
   (if (seq elementos)
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora
     )))

(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta 0 []))

(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta  []))