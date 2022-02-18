# Kafka stream com Spring boot
- kafka stream é uma biblioteca do lado do cliente, que permite processar um fluxo de eventos de maneira declarativa.
- nos fornece algumas operações, como: junções, agregação, filtragem de um ou mais eventos
- um conceito importante do kafka stream é o de topologia de processar:
  - um esquema das operações do kafka stream em um ou mais fluxos de eventos
  - considerada como um grafo acíclico direcionado, onde os nós são categorizados como origem, processador e coletor, enquanto as flexas são os eventos de fluxo.
