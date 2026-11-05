<div align="center">

# 🗂️ Estrutura de Dados em Java

Implementações próprias de estruturas de dados e algoritmos clássicos, desenvolvidas durante a graduação em Ciência da Computação na **UFCG**.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![UFCG](https://img.shields.io/badge/UFCG-Ci%C3%AAncia%20da%20Computa%C3%A7%C3%A3o-8B0000?style=for-the-badge)
![Estruturas](https://img.shields.io/badge/Estruturas%20de%20Dados-7-blue?style=for-the-badge)
![Ordenação](https://img.shields.io/badge/Algoritmos%20de%20Ordena%C3%A7%C3%A3o-5-success?style=for-the-badge)

</div>

---

## 🧭 Mapa do repositório

```mermaid
flowchart LR
    R([LabEstruturaDadosJava])
    R --> E[Estruturas]
    R --> A[Algoritmos]
    E --> BST[BST]
    E --> HEAP[HeapBinaria]
    E --> LL[linkedList]
    E --> Q[queue]
    E --> S[stack]
    A --> BB[buscaBinaria]
    A --> SORT[sorting]
    SORT --> B1[Bubble Sort]
    SORT --> B2[Selection Sort]
    SORT --> B3[Insertion Sort]
    SORT --> B4[Merge Sort]
    SORT --> B5[Quick Sort]
```

---

## 🌳 Binary Search Tree

Cada nó guarda um valor; menores à esquerda, maiores à direita.

```mermaid
graph TD
    N8((8)) --> N3((3))
    N8 --> N10((10))
    N3 --> N1((1))
    N3 --> N6((6))
    N10 --> N14((14))
    N6 --> N4((4))
    N6 --> N7((7))
```

## ⛰️ Binary Heap (Min-Heap)

O menor elemento sempre fica na raiz.

```mermaid
graph TD
    H1((1)) --> H3((3))
    H1 --> H2((2))
    H3 --> H7((7))
    H3 --> H5((5))
    H2 --> H4((4))
    H2 --> H6((6))
```

## 🔗 Linked List

```mermaid
flowchart LR
    HEAD([head]) --> A[10 | •] --> B[20 | •] --> C[30 | •] --> NULL([null])
```

## 📚 Stack (LIFO) e 🚶 Queue (FIFO)

```mermaid
flowchart LR
    subgraph Stack
        direction TB
        T3[3 ← topo]
        T2[2]
        T1[1]
        T3 --- T2 --- T1
    end
    subgraph Queue
        direction LR
        F[início → 1] --- Q2[2] --- Q3[3 ← fim]
    end
```

## 🔍 Busca Binária

```mermaid
flowchart TD
    S([Início]) --> M{meio == alvo?}
    M -- sim --> OK([Encontrado])
    M -- alvo menor --> L[Busca na metade esquerda] --> M
    M -- alvo maior --> R[Busca na metade direita] --> M
    M -- intervalo vazio --> NO([Não encontrado])
```

---

## ⏱️ Complexidade

### Estruturas

| Estrutura | Inserção | Busca | Remoção |
|---|---|---|---|
| **BST** | O(log n) médio · O(n) pior | O(log n) médio · O(n) pior | O(log n) médio · O(n) pior |
| **Binary Heap** | O(log n) | O(n) | O(log n) |
| **Linked List** | O(1) no início | O(n) | O(n) |
| **Stack** | O(1) | O(n) | O(1) |
| **Queue** | O(1) | O(n) | O(1) |
| **Busca Binária** | — | O(log n) | — |

### Algoritmos de ordenação

| Algoritmo | Melhor caso | Médio | Pior caso | Estável |
|---|---|---|---|---|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | ✅ |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | ❌ |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | ✅ |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | ✅ |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | ❌ |

```mermaid
quadrantChart
    title Ordenação: velocidade x simplicidade
    x-axis Mais simples --> Mais sofisticado
    y-axis Mais lento --> Mais rápido
    quadrant-1 Rápido e sofisticado
    quadrant-2 Rápido e simples
    quadrant-3 Lento e simples
    quadrant-4 Lento e sofisticado
    Bubble Sort: [0.12, 0.12]
    Selection Sort: [0.2, 0.18]
    Insertion Sort: [0.3, 0.3]
    Merge Sort: [0.78, 0.85]
    Quick Sort: [0.85, 0.9]
```

---

## 📁 Estrutura

```
LabEstruturaDadosJava
├── BST
├── HeapBinaria
├── buscaBinaria
├── linkedList
├── queue
├── sorting
└── stack
```

---

<div align="center">

**Guilherme Macario** · Ciência da Computação · UFCG · Campina Grande, PB

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/guilherme-macario-900a7733b/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white)](https://github.com/usguilherme)

</div>