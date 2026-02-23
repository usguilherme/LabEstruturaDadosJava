package BST;

public class BST<T extends Comparable<T>> {

    private BtNode<T> root;


    public boolean isEmpty() {
        return root == null;
    }

    public BtNode<T> search(T element) {
        BtNode<T> result = null;
        if (element != null && root != null) {
            result = searchRecursivoBst(element, root);
        }
        return result;
    }

    
    public BtNode<T> searchRecursivoBst(T element, BtNode<T> node) {
        BtNode<T> result = null; 
        if (element != null && node != null) {
            int comparacao = element.compareTo(node.getData());

            if (comparacao == 0) { //Achei o elemento
                result = node;
            } else if (comparacao > 0) {                                              //element > node.data, vou pra direita
                    result = searchRecursivoBst(element, node.getRight());    
            } else {                                                                //Element > node.getData, vou pra esquerda
                    result = searchRecursivoBst(element, node.getLeft());    
            }
        }
        
        return result;
    }

    public void insert(T value) {
        throw new UnsupportedOperationException("Escolha insertRecursivo");
    }

    public void remove(T key) {
        throw new UnsupportedOperationException("Escolha removeRecursivo");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int height() {
        throw new UnsupportedOperationException("Escolha heightRecursivo");
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

    /* ================= MÉTODOS RECURSIVOS ================= */

    private boolean isEmptyRecursivo() {
        throw new UnsupportedOperationException("Unimplemented method 'isEmptyRecursivo'");
    }

    private int heightRecursivo(BtNode<T> node) {
        throw new UnsupportedOperationException("Unimplemented method 'heightRecursivo'");
    }

    private BtNode<T> searchRecursivo(BtNode<T> node, T element) {
        throw new UnsupportedOperationException("Unimplemented method 'searchRecursivo'");
    }

    private BtNode<T> insertRecursivo(BtNode<T> node, T value) {
        throw new UnsupportedOperationException("Unimplemented method 'insertRecursivo'");
    }

    private BtNode<T> removeRecursivo(BtNode<T> node, T key) {
        throw new UnsupportedOperationException("Unimplemented method 'removeRecursivo'");
    }

    private void preOrderRecursivo(BtNode<T> node) {
        throw new UnsupportedOperationException("Unimplemented method 'preOrderRecursivo'");
    }

    private void orderRecursivo(BtNode<T> node) {
        throw new UnsupportedOperationException("Unimplemented method 'orderRecursivo'");
    }

    private void postOrderRecursivo(BtNode<T> node) {
        throw new UnsupportedOperationException("Unimplemented method 'postOrderRecursivo'");
    }

    private int sizeRecursivo(BtNode<T> node) {
        throw new UnsupportedOperationException("Unimplemented method 'sizeRecursivo'");
    }
}