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

}