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
  
}
