package bst;

public class BtNode<T extends Comparable<T>> {

    private T data;
    private BtNode<T> left;
    private BtNode<T> right;
    private BtNode<T> parent;

    // Construtor NIL
    public BtNode() {
        this.data = null;
    }

    // Construtor normal
    public BtNode(T data) {
        this.data = data;
        this.left = new BtNode<>();
        this.right = new BtNode<>();
        this.left.parent = this;
        this.right.parent = this;
    }

    public boolean isNil() {
        return this.data == null;
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public BtNode<T> getLeft() { return left; }
    public void setLeft(BtNode<T> left) { this.left = left; }

    public BtNode<T> getRight() { return right; }
    public void setRight(BtNode<T> right) { this.right = right; }

    public BtNode<T> getParent() { return parent; }
    public void setParent(BtNode<T> parent) { this.parent = parent; }
}