package BST;

public class BtNode<T> {

    private T data;
    private BtNode<T> left;
    private BtNode<T> right;
    private BtNode<T> parent;

    public BtNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BtNode<T> getLeft() {
        return left;
    }

    public void setLeft(BtNode<T> left) {
        this.left = left;
    }

    public BtNode<T> getRight() {
        return right;
    }

    public void setRight(BtNode<T> right) {
        this.right = right;
    }

    public BtNode<T> getParent() {
        return parent;
    }

    public void setParent(BtNode<T> parent) {
        this.parent = parent;
    }

    /* ================= MÉTODOS NO PADRÃO RECURSIVO ================= */

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Escolha isEmptyRecursivo");
    }


    public int height() {
        throw new UnsupportedOperationException("Escolha heightRecursivo");
    }


    public BtNode<T> search(T element) {
        throw new UnsupportedOperationException("Escolha searchRecursivo");
    }


    public void insert(T value) {
        throw new UnsupportedOperationException("Escolha insertRecursivo");
    }


    public void remove(T key) {
        throw new UnsupportedOperationException("Escolha removeRecursivo");
    }


    public T[] preOrder() {
        throw new UnsupportedOperationException("Escolha preOrderRecursivo");
    }


    public T[] order() {
        throw new UnsupportedOperationException("Escolha orderRecursivo");
    }


    public T[] postOrder() {
        throw new UnsupportedOperationException("Escolha postOrderRecursivo");
    }


    public int size() {
        throw new UnsupportedOperationException("Escolha sizeRecursivo");
    }

    
}
