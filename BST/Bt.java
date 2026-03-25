package BST;

import java.util.List;

public interface Bt<T extends Comparable<T>> {

    // ===== Estrutura básica =====
    BtNode<T> getRoot();

    boolean isEmpty();

    int size();

    int height();

    BtNode<T> search(T elem);

    void insert(T value);

    void remove(T key);

    List<T> preOrder();   // Pré-ordem

    List<T> order();      // Em-ordem (in-order)

    List<T> postOrder();  // Pós-ordem

    boolean equals(Bt<T> other); // Verifica se duas árvores são iguais

    int level(T element, int nivel); // Retorna o nível de um elemento

    List<T> path(T element); // Caminho da raiz até o elemento

    void mirror(); // Espelha (inverte) a árvore

    List<T> nodesAtLevel(int level); // Retorna todos os nós de um nível específico

    T min(); // Retorna o menor elemento da árvore.

    T max();// Retorna o maior elemento da árvore.

    T successor(T element);// Retorna o sucessor em ordem (in-order).

    T predecessor(T element);// Retorna o antecessor em ordem (in-order).

    int countLeaves();// Conta quantos nós folha existem na árvore.

    int diameter();// Calcula o diâmetro da árvore.

    boolean isFull(); // Verifica se a árvore é estritamente binária (Full).

    boolean isComplete();// Verifica se a árvore é completa (Complete Binary Tree)

    T lowestCommonAncestor(T n1, T n2); // Retorna o menor ancestral comum (Lowest Common Ancestor - LCA)
}