package BST;

public class BST<T extends Comparable<T>> {

    private BtNode<T> root;


    public boolean isEmpty() {
        return root == null;
    }

    public BtNode<T> search(T element) {
        BtNode<T> result = null;
        if (element != null) {
            result = searchRecursivoBst(element, root);
        }
         
        return result;
    }

    
    private BtNode<T> searchRecursivoBst(T element, BtNode<T> node) {
        BtNode<T> result = null;
        if (element != null && node != null) {
            int comp = element.compareTo(node.getData()); //compare
            if (comp == 0) {
                result = node; //Find
            } else if (comp > 0) {
                 result = searchRecursivoBst(element, node.getRight());
            } else {
                result = searchRecursivoBst(element, node.getLeft());
            }
        }
        return result;
    }

    public void insert(T value) {
        if (root == null) {
            root = new BtNode<>(value);
        } else {
            insertRecursivoBst(value, root);
        }
    }


    private void insertRecursivoBst(T element, BtNode<T> node) {
        int comp = element.compareTo(node.getData());
        if (comp > 0) { //Element > node.data, direita
            if (node.getRight() == null) {
                node.setRight(new BtNode<>(element)); //Adiciono o nó a direita
            } else {
                insertRecursivoBst(element, node.getRight()); //Continuo percorrendo a direita
            }
        } else if (comp < 0) { //Element < node.data, esquerda
            if (node.getLeft() == null) {
                node.setLeft(new BtNode<>(element)); //Adiciono o nó a esqueda
            } else {
                insertRecursivoBst(element, node.getLeft());
            }
        } 

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