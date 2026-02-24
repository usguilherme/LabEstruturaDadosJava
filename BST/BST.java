package BST;

import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> {

    private BtNode<T> root;


    public boolean isEmpty() {
        return root == null || root.isNil();
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
        if (element != null && node != null && !node.isNil()) {
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
        if (root == null || root.isNil()) {
            root = new BtNode<>(value);
        } else {
            insertRecursivoBst(value, root);
        }
    }


    private void insertRecursivoBst(T element, BtNode<T> node) {
        int comp = element.compareTo(node.getData());
        if (comp > 0) { //Element > node.data, direita
            if (node.getRight() == null || node.getRight().isNil()) {
                BtNode<T> newNode = new BtNode<>(element);
                newNode.setParent(node); // Necessário para o remove funcionar
                node.setRight(newNode); //Adiciono o nó a direita
            } else {
                insertRecursivoBst(element, node.getRight()); //Continuo percorrendo a direita
            }
        } else if (comp < 0) { //Element < node.data, esquerda
            if (node.getLeft() == null || node.getLeft().isNil()) {
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
         if (node != null && !node.isNil()) { //Achei o nó na bst
            if ((node.getLeft() == null || node.getLeft().isNil()) 
                && (node.getRight() == null || node.getRight().isNil())) {//Nó folha
                if (node == root) { //Meu nó a remover é a raiz
                    root = null;
                } else { //Ele pode ser um nó a esquerda, ou a direita de algum nó
                    if (node.getParent().getLeft() == node) { //Verificando se o meu nó que achei é filho a esquerda do pai
                        node.getParent().setLeft(null); //exclui o nó da esquerda
                    } else {
                        node.getParent().setRight(null); //Nó é filho a direita, então excluo o da direita
                    }
                }
            } else if ((node.getLeft() == null || node.getLeft().isNil()) 
                    || (node.getRight() == null || node.getRight().isNil())) { //Nó com pelo menos um filho
                BtNode<T> child;
                if (node.getLeft() != null && !node.getLeft().isNil()) {
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
                BtNode<T> sucessor = sucessor(node);
                node.setData(sucessor.getData());
                removeRecursivoBst(sucessor.getData(), node.getRight());
            }
        }
    }

    private BtNode<T> sucessor(BtNode<T> node) {
        BtNode<T> noAtual = node.getRight();
        while (noAtual != null && !noAtual.isNil() 
               && noAtual.getLeft() != null && !noAtual.getLeft().isNil()) {
            noAtual = noAtual.getLeft();
        }
        return noAtual;
    }

    public boolean equals(BST<T> other) {
        boolean result = false;
        if (other != null) {
            result = equalsRecursivoBst(this.root, other.root);
        }  
        return result;
    }

    private boolean equalsRecursivoBst(BtNode<T> node, BtNode<T> node1) {
        boolean result = true;
        if (!node.isNil() && !node1.isNil()) {
            
            if (!node.getData().equals(node1.getData())) {
                result = false;
            }
            if (result) {
                result = equalsRecursivoBst(node.getLeft(), node1.getLeft()) &&
                equalsRecursivoBst(node.getRight(), node1.getRight());
            } 
        }

        return result;
    }


    public List<T> path(T element) {
        List<T> result = new ArrayList<>();
        if (element != null) {
            result = path(element, result, root);
        }
        return result;
    }

    private List<T> path(T element, List<T> array, BtNode<T> node) { 
        if (!node.isNil()) {
            int comp = element.compareTo(node.getData());
            if (comp > 0) { //Element > node.data
                array.add(node.getData());
                path(element, array, node.getRight());
            } else if (comp < 0) { //Element < node.data
                array.add(node.getData());
                path(element, array, node.getLeft());
            } else { //Element == node.data
                array.add(node.getData());
            }
        }
        return array;

    }

    public void mirror() {
        mirrorRecursivoBst(root);
    }

    private void mirrorRecursivoBst(BtNode<T> node) {
        if (!node.isNil()) {
            BtNode<T> nodeEsq = node.getLeft();
            BtNode<T> nodeDir = node.getRight();
            node.setLeft(nodeDir);
            node.setRight(nodeEsq);
            
            mirrorRecursivoBst(nodeEsq); //vou repetir tudo para a esquerda
            mirrorRecursivoBst(nodeDir); //vou repetir tudo para a direita
        }
    }

    public int level(T element) {
        int result = -1;
        if (element != null) {
            result = levelRecursivoBst(element, root);
        }
        return result;
    }

    private int levelRecursivoBst(T element, BtNode<T> node) {
        int result = -1;
        if (!node.isNil()) {
            int comp = element.compareTo(node.getData()); 
            if (!node.getData().equals(element)) { //Se eu ainda não achei
                if (comp > 0) { //Element > node.data, vou pra direita
                    result = 1 + levelRecursivoBst(element, node.getRight());
                }else { //Element < node.data, vou pra esquerda
                    result = 1 + levelRecursivoBst(element, node.getLeft());
                }  
            } else { //Se eu achar o elemento
                result += 1;
            }      
        }
        return result;
    }
    
    public List<T> nodesAtLevel(int level) {
        List<T> array = new ArrayList<>();
        nodesAtLevel(level, array, root);
        return array;
    }

    private void nodesAtLevel(int level, List<T> array, BtNode<T> node) {
        if (!node.isNil()) {
            if (level == 0) {
                array.add(node.getData());
            } else {
                nodesAtLevel(level - 1, array, node.getLeft());
                nodesAtLevel(level - 1, array, node.getRight());
            }
        }
    }


    public List<T> preOrder() {
        List<T> array = new ArrayList<>();
        preOrderRecursivoBst(root, array);
        return array;
    }

    private void preOrderRecursivoBst(BtNode<T> node, List<T> array) {
        if (!node.isNil()) {
            array.add(node.getData()); //Adiciona
            preOrderRecursivoBst(node.getLeft(), array); //Vou pra esquerda 
            preOrderRecursivoBst(node.getRight(), array); //Vou pra direita
        }

    }
    
    public List<T> order() {
        List<T> array = new ArrayList<>();
        orderRecursivoBst(root, array);
        return array;
    }

    public void orderRecursivoBst(BtNode<T> node, List<T> array) {
        if (!node.isNil()) {
            orderRecursivoBst(node.getLeft(), array); //Esquerda
            array.add(node.getData()); //Adiciono nó atual
            orderRecursivoBst(node.getRight(), array); //Direita
        }
    }

    public List<T> postOrder() {
        List<T> array = new ArrayList<>();
        postOrderRecursivoBst(root, array);
        return array;
    }


    public void postOrderRecursivoBst(BtNode<T> node, List<T> array) {
        if (!node.isNil()) {
            postOrderRecursivoBst(node.getLeft(), array);
            postOrderRecursivoBst(node.getRight(), array);
            array.add(node.getData());
        }
    }

    public int size() {
        return sizeRecursivoBst(root);
    }

    public int sizeRecursivoBst(BtNode<T> node) {
        int result = 0;
        if (!node.isNil()) {
            result = 1 + sizeRecursivoBst(node.getLeft()) + sizeRecursivoBst(node.getRight());
        }
        return result;
    }

    public int height() {
        return heightRecursivoBst(root);
    }
    
    private int heightRecursivoBst(BtNode<T> node) {
        int altura = -1;
        if (!node.isNil()) {
            int alturaEsquerda = heightRecursivoBst(node.getLeft());
            int alturaDireita = heightRecursivoBst(node.getRight());
            altura = 1 + Math.max(alturaEsquerda, alturaDireita);
        }
        return altura; 
    }

}