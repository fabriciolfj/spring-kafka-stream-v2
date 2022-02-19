# Kafka stream com Spring boot
- kafka stream é uma biblioteca do lado do cliente, que permite processar um fluxo de eventos de maneira declarativa.
- nos fornece algumas operações, como: junções, agregação, filtragem de um ou mais eventos
- um conceito importante do kafka stream é o de topologia de processar:
  - um esquema das operações do kafka stream em um ou mais fluxos de eventos
  - considerada como um grafo acíclico direcionado, onde os nós são categorizados como origem, processador e coletor, enquanto as flexas são os eventos de fluxo.

## Obs:
- kafkalistener não funciona para ouvir topics, onde kafkstream populou
- kafkastream se basea no produtor e consumidor

### Detalhes:
```
Hoje em dia você também pode usar o ksqlDB, o banco de dados de streaming de eventos do Kafka, para processar seus dados no Kafka. O ksqlDB é construído sobre a API de fluxos do Kafka e também vem com suporte de primeira classe para fluxos e tabelas.

qual é a diferença entre API de consumidor e API de fluxos?

A biblioteca Streams do Kafka (https://kafka.apache.org/documentation/streams/) é construída sobre os clientes produtores e consumidores do Kafka. O Kafka Streams é significativamente mais poderoso e também mais expressivo do que os clientes simples.

É muito mais simples e rápido escrever um aplicativo do mundo real do início ao fim com o Kafka Streams do que com o consumidor simples.

Além do Kafka Streams, você também pode usar o banco de dados de streaming ksqlDB para processar seus dados no Kafka. O ksqlDB separa sua camada de armazenamento (Kafka) de sua camada de computação (o próprio ksqlDB; ele usa Kafka Streams para a maioria de suas funcionalidades aqui). Ele suporta essencialmente os mesmos recursos do Kafka Streams, mas você escreve instruções SQL de streaming em vez de código Java ou Scala. Você pode interagir com o ksqlDB por meio de uma interface do usuário, CLI e uma API REST; ele também tem um cliente Java nativo caso você não queira usar REST. Por fim, se você preferir não ter que autogerenciar sua infraestrutura, o ksqlDB está disponível como um serviço totalmente gerenciado no Confluent Cloud.
```
