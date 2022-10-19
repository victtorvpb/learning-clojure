(ns curso.aula4)

(def precos   [30 700 1000])

(println (precos 0))
;; (println (precos 17))
(println (get precos 2))
(println (get precos 17 0))


(println (update precos 1 inc))

; CODIGO AULA ANTERIOR

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-desconto (/ 10 100)
          desconto (* valor-bruto taxa-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 1000))

(println precos)

(map valor-descontado precos)

(println (range 10))

(println (filter even? (range 10)))

(println (filter aplica-desconto? precos))

(def range-numeros (range 10))
(println range-numeros)


(reduce + precos)


(defn minha-soma
  [valor-1 valor-2]
  (println "somando valores" valor-1 valor-2)
  (+ valor-1 valor-2))

(reduce minha-soma precos)
(println (reduce minha-soma range-numeros))

;EXECUTANDO REDUCE COM PARAMETRO INICIAL
(println (reduce minha-soma 100 range-numeros))

