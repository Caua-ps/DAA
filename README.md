# DAA — Desenho e Análise de Algoritmos

Exercícios da unidade curricular **Desenho e Análise de Algoritmos** (Licenciatura em Ciência de Computadores,
FCUP), resolvidos em Java e submetidos no sistema de avaliação automática Mooshak.

## Conteúdo

| Pasta | Exercício | Ideia |
|-------|-----------|-------|
| `mooshak1/exA.java` | Seguir uma cadeia de referências a partir de uma pessoa inicial | Simulação com vetor de visitados para detetar ciclos e índices inválidos |
| `mooshak1/exB.java` | Caixa automática com troco limitado | Troco *greedy* com o stock de moedas disponível e contagem das transações sem troco exato |

## Como executar

Cada ficheiro é um programa independente que lê do *standard input*:

```bash
cd mooshak1
javac exA.java
java exA < input.txt
```
