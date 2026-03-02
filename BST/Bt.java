package BST;

import java.util.List;

public interface Bt<T> {

    BtNode<T> getRoot();

    boolean isEmpty();

    int height();

    BtNode<T> search(T elem);

    void insert(T value);

    void remove(T key);

    List<T> preOrder();

    List<T> order();      // in-order

    List<T> postOrder();

    int size();

    boolean equals(Bt<T> other); // Verifica se duas BST são iguais

    int level(T element, int nivel); // Retorna o nível de um elemento na árvore

    List<T> path(T element); // Retorna o caminho da raiz até o elemento

    void mirror(); // Espelha (inverte) a árvore

    List<T> nodesAtLevel(int level); // Retorna todos os nós de um nível específico

    /**
     * Retorna o elemento com o menor valor armazenado na árvore.
     * Útil para entender a propriedade da subárvore esquerda na BST.
     */
    T min();

    /**
     * Retorna o elemento com o maior valor armazenado na árvore.
     * Útil para entender a propriedade da subárvore direita na BST.
     */
    T max();

    /**
     * Retorna o sucessor em-ordem (in-order) de um elemento.
     * O sucessor é o menor valor que é maior que o elemento fornecido.
     * Cenários de teste: nó com subárvore direita vs nó sem subárvore direita (sobe pelo pai).
     */
    T successor(T element);

    /**
     * Retorna o antecessor em-ordem (in-order) de um elemento.
     * O antecessor é o maior valor que é menor que o elemento fornecido.
     */
    T predecessor(T element);

    /**
     * Conta a quantidade de nós folhas (nós que não possuem filhos, ou seja, filhos são NIL).
     * Excelente para treinar recursão de base.
     */
    int countLeaves();

    /**
     * Calcula o diâmetro da árvore (ou largura).
     * O diâmetro é o número de nós no caminho mais longo entre dois nós quaisquer.
     * Nota: O caminho pode ou não passar pela raiz.
     */
    int diameter();

    /**
     * Verifica se a árvore é estritamente binária (Full/Strict Binary Tree).
     * Propriedade: Todo nó deve ter 0 ou 2 filhos. Não pode haver nó com apenas 1 filho.
     */
    boolean isFull();

    /**
     * Verifica se a árvore é completa (Complete Binary Tree).
     * Propriedade: Todos os níveis, exceto talvez o último, estão totalmente preenchidos,
     * e todos os nós do último nível estão alinhados o mais à esquerda possível.
     * Geralmente implementado usando BFS (fila).
     */
    boolean isComplete();

    /**
     * Encontra o Menor Ancestral Comum (Lowest Common Ancestor - LCA) entre dois elementos.
     * O LCA de n1 e n2 é o ancestral mais baixo (mais profundo) que tem n1 e n2 como descendentes.
     */
    T lowestCommonAncestor(T n1, T n2);
}