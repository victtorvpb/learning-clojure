(ns clojure-colections.aula1)


;; TIPOS DE COLEÇÕES
;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]
;{ "guilherme" 37, "paulo" 39}
;'(1 2 3 4 5)


;(map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

; PEGA O PRIMEIRO
(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"] ))

; PEGA O RESTO
(println (rest ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"] ))

; RETORNA VETOR VAZIO
(println (rest []))

; RETORNA A LISTA MENOS O PRIMEIRO
(println (next ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"] ))

; RETORNA NIL
(println (next []))


; RETORNA NIL
(println (seq []))
(println (seq [1 2 3 4 5]))


(println "\n\n\n\n\n\n\n Meu mapa")


; MY RESOLUTION
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (if (> (count (next sequencia)) 0)
      (meu-mapa funcao (next sequencia)))))


(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])


; USANDO REST
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]

    (if primeiro
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
; ESSA FUNÇÃO TEM UM PROBLEMA SE EU TIVER UM ITEM FALSE
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])

; USANDO REST VERIFICANDO SE PRIMEIRO É NULO
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
; ESSA FUNÇÃO TEM UM PROBLEMA SE EU TIVER UM ITEM FALSE
(println "------------- CHAMANDO A FUNÇÃO ---------------")
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println [] )
(meu-mapa println nil)

; FORÇANDO UM STACKOVERFLOWERROR
(meu-mapa println (range 1000000))


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        ; AVISANDO AO CLOJURE QUE É UMA RECURSAO DESTA FUNÇÃO
        (recur  funcao (rest sequencia))))))

(meu-mapa println (range 1000000))
