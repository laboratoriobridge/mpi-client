# mpi-client

![Build Status](https://github.com/laboratoriobridge/mpi-client/actions/workflows/maven.yml/badge.svg)
[![codecov](https://codecov.io/gh/laboratoriobridge/mpi-client/branch/master/graph/badge.svg)](https://codecov.io/gh/laboratoriobridge/mpi-client)

Implementação de client para um servidor MPI (Master Patient Index) utilizando mensagens SOAP (PIX/PDQ) baseadas na especificação técnica para integração do DATASUS.

## Links

- [Catálogo de serviços do DATASUS](http://datasus.saude.gov.br/interoperabilidade/catalogo-de-servicos)
- [Especificação técnica do DATASUS](http://datasus.saude.gov.br/images/Interoperabilidade/Especificacao%20Tecnica%20para%20Integracao%20PIX-PDQ%20com%20o%20Cartao%20Nacional%20de%20Saude%20v5%2020.pdf)
- [Projeto de exemplo SOAP UI](http://datasus.saude.gov.br/images/Interoperabilidade/IHE-MS.zip)

## Operações suportadas

- ITI-44 (PIXv3: add)
- ITI-47 (PDQv3)

## Uso

**Criando o client:**
```java
MPIClient client = new MPIClient(MPIClientOptions.builder()
  .pixUrl("pixUrl")
  .pdqUrl("pdqUrl")
  .user("user")
  .password("password")
  .build());
```

**Inserindo um cidadão:**
```java
Cidadao cidadao = Cidadao.builder()
  .nome("nome")
  // etc
  .build();
client.inserir(cidadao);
```

**Buscando cidadãos:**
```java
PDQParameters parameters = PDQParameters.builder()
  .nome("nome")
  // etc
  .build();
List<Cidadao> result = client.consultar(parameters);
```

## Roadmap
- Suporte às outras operações do ITI-44 (revise / merge) e ITI-45
- Suporte aos perfis públicos do IHE
- Suporte à outros value sets
​
