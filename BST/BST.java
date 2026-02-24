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
                BtNode<T> newNode = new BtNode<>(element);
                newNode.setParent(node); // Necessário para o remove funcionar
                node.setRight(newNode); //Adiciono o nó a direita
            } else {
                insertRecursivoBst(element, node.getRight()); //Continuo percorrendo a direita
            }
        } else if (comp < 0) { //Element < node.data, esquerda
            if (node.getLeft() == null) {
                BtNode<T> newNode = new BtNode<>(element);
                newNode.setParent(node); // Necessário para o remove funcionar
                node.setLeft(newNode); //Adiciono o nó a esqueda
            } else {
                insertRecursivoBst(element, node.getLeft());
            }
        } 
    }

    
    public void remove(T key) {
        if (key != null) {
            removeRecursivoBst(key, root);
        }
    }

    private void removeRecursivoBst(T element, BtNode<T> node ) {
         node = searchRecursivoBst(element, node); //Já cheguei no nó que eu quero
         if (node != null) { //Achei o nó na bst
            if (node.getLeft() == null && node.getRight() == null) {//Nó folha
                if (node == root) { //Meu nó a remover é a raiz
                    root = null;
                } else { //Ele pode ser um nó a esquerda, ou a direita de algum nó
                    if (node.getParent().getLeft() == node) { //Verificando se o meu nó que achei é filho a esquerda do pai
                        node.getParent().setLeft(null); //exclui o nó da esquerda
                    } else {
                        node.getParent().setRight(null); //Nó é filho a direita, então excluo o da direita
                    }
                }
            } else if (node.getLeft() == null || node.getRight() == null) { //Nó com pelo menos um filho
                BtNode<T> child;
                if (node.getLeft() != null) {
                    child = node.getLeft();
                } else {
                    child = node.getRight();
                }

                if (node == root) { //Se eu tiver um nó, que é root, e só tem um filho
                    root = child;
                    child.setParent(null);
                } else {
                    child.setParent(node.getParent()); //O pai do meu filho, vai ser o pai do meu atual
                    if (node.getParent().getLeft() == node) { //o meu atual é um filho a esquerda do seu pai
                        node.getParent().setLeft(child);
                    } else {
                        node.getParent().setRight(child); 
                    }
                }
            } // CASO 3: O nó tem dois filhos
            else {
                // Encontra o sucessor: o menor valor da subárvore à direita
                BtNode<T> sucessor = sucessor(node);
                
                // Copia o valor do sucessor para o nó atual (sobrescrevendo o valor a ser removido)
                node.setData(sucessor.getData());
                
                // Chama recursivamente para remover o nó sucessor original (que agora é duplicado)
                // Inicia a busca na subárvore à direita para evitar buscar na árvore toda
                removeRecursivoBst(sucessor.getData(), node.getRight());
            }
        }
    
    }

    private BtNode<T> sucessor(BtNode<T> node) {
        BtNode<T> noAtual = node.getRight();
        while (noAtual != null && noAtual.getLeft() != null) {
            noAtual = noAtual.getLeft();
        }
        return noAtual;
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