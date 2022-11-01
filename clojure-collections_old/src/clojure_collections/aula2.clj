(ns clojure-collections.aula2)


;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]

(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora) (rest elementos))
  )

(println (conta 0 ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))