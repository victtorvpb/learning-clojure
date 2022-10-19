(ns curso.aula6)

(def pedido {
             :mochila { :quantidade 2, :preco 80 }
             :camiseta {:quantidade 3, :preco 40}
             })

(defn imprime-e-15 [valor]
  (println "valor"  (class valor) valor)
  15
  )

(println (map imprime-e-15 pedido))

;(defn imprime-e-15 [chave valor]
;  (println chave "e" valor)
;  15
;  )
;
;(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  (println chave "e" valor)
  15
  )

(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  valor
  )

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (reduce + (map preco-dos-produtos pedido)))


(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (reduce + (map preco-dos-produtos pedido)))


(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido))
  )

(println "total do pedido" (total-do-pedido pedido))

; THEADING LAST
(defn total-do-pedido
  [pedido]
  (->> pedido
      (map preco-dos-produtos ,,,)
      (reduce + ,,,)))

(println "total do pedido with treading" (total-do-pedido pedido))


(defn preco-dos-produtos [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-dos-produtos ,,,)
       (reduce + ,,,)))

(println "total do pedido with treading" (total-do-pedido pedido))



(def pedido {
             :mochila { :quantidade 2, :preco 80 }
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1 :preco 0}
             })

(defn gratuito?
  "docstring"
  [item]
   (<= (get item :preco 0) 0))

(println "imprimindo gratuito" (filter (fn[[chave item]] (gratuito? item)) pedido))
(println "imprimindo gratuito" (filter #(gratuito? (second %)) pedido))
