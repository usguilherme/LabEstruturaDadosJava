package BST;

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
}
