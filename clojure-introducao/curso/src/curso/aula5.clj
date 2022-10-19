(ns curso.aula5)

(def estoque {"Mochila"  10,
              "Camiseta" 5})

(println estoque)


(println (count estoque))

(println (keys estoque))

(println (vals estoque))


(def estoque {:mochila 10, :camisete 5})

(println (assoc estoque :cadeira 3))
(println estoque)

(println (update estoque :mochila inc))


(defn tira-um
  "docstring"
  [valor]
  (dec valor)
  )
(println (update estoque :mochila tira-um))


(def pedido {
             :mochila { :quantidade 2, :preco 80 }
             :camiseta {:quantidade 3, :preco 40}
             })
(println pedido)


(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)

(println (get pedido :mochila))

(println "pegando a chave interna explicitamente " (get (:mochila pedido ) :preco))
(println "pegando a chave interna implicitamente" (:preco (:mochila pedido )))

(println (update-in pedido [:mochila :quantidade] inc))

; THREADING FIRST
(println (-> pedido
             :mochila
             :quantidade))
(-> pedido
    :mochila
    :quantidade
    println)
