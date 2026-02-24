package BST;

import java.util.List;

public interface Bt<T> {

    BtNode<T> getRoot();

    boolean isEmpty();

    int height();

    BtNode<T> search(T elem);

    void insert(T value);

    void remove(T key);

    T[] preOrder();

    T[] order();      // in-order

    T[] postOrder();

    int size();

    boolean equals(Bt<T> other); // Verifica se duas BST são iguais

    int level(T element); // Retorna o nível de um elemento na árvore

    List<T> path(T element); // Retorna o caminho da raiz até o elemento

    void mirror(); // Espelha (inverte) a árvore
}