package BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para praticar os métodos de Árvore Binária de Busca (BST).
 * FOCO: Recursão, Casos Base e Navegação (Left/Right).
 */
public class BSTRefazer<T extends Comparable<T>> {

    private BtNode<T> root;

    // --- MÉTODOS BÁSICOS ---

    public boolean isEmpty() {
        return (root.isNil() || root == null);
    }

    public BtNode<T> search(T element) {
        return searchAux(element, root);
    }

    private BtNode<T> searchAux(T element, BtNode<T> node) {
        BtNode<T> result = null;
        if (element != null && !node.isNil()) {
            int comp = node.getData().compareTo(element); //Comparando node.data e element
            if (comp == 0) { //Achei o meu elemento
                result = node;
            } else if (comp > 0) { //node.data > element, tenho que ir pra esquerda
                result = searchAux(element, node.getLeft());
            } else {
                result = searchAux(element, node.getRight());
            }
        }
        return result;
    }


    public void insert(T element) {
        inserirAux(element, root);
    }

    private void inserirAux(T element, BtNode<T> node) {
        if (node.isNil()) {
            node.setData(element); 
            node.setLeft(new BtNode<T>()); //Apenas criando os filhos a esquerda e direita
            node.setRight(new BtNode<T>());
        } else {
            int comp = node.getData().compareTo(element) // node.data e element
            if (comp > 0) { //node.data > element, vou pra esquerda
                inserirAux(element, node.getLeft());
            } else if (comp < 0) {
                inserirAux(element, node.getRight());
            }
        }
    }


    public void remove(T key) {
        // TODO: Localizar o nó e tratar os 3 casos (folha, 1 filho, 2 filhos)
    }

    // --- MÉTODOS DE INFORMAÇÃO ---

    public int size() {
        return sizeAux(root);
    }

    public int sizeAux(BtNode<T> node) {
        int result = 0;
        if (!node.isNil()) {
            result =  1 + sizeAux(node.getLeft()) + sizeAux(node.getRight());
        }
        return result;
    }


    public int height() {
        return heightAux(root);
    }

    private int heightAux(BtNode<T> node) {
        int result = -1;
        if (!node.isNil()) {
            int alturaEsquerda = heightAux(node.getLeft());
            int alturaDireita = heightAux(node.getRight());
            result = 1 + Math.max(alturaDireita, alturaEsquerda);  
        }
        return result;
    }

    public T min() {
       return min(root);
    }

    public T min(BtNode<T> node) {
        T result = null;
        if (!node.isNil()) {
            if (node.getLeft().isNil()) {
                result = node.getData();
            } else {
                result = min(node.getLeft());
            }
        }
        return result;
    }


    public T max() {
        return max(root);
    }

    private T max(BtNode<T> node) {
        T result = null;
        if (!node.isNil()) {
            if (node.getRight().isNil()) {
                result = node.getData();
            } else {
                result = max(node.getRight());
            }
        }
        return result;
    }



    public int level(T element) {
        // TODO: Distância da raiz até o nó (Raiz = nível 0)
        return -1;
    }


    private int levelAux(T element, BtNode<T> node) {
        int result = -1;
        if (!node.isNil()) {
            int comp = node.getData().compareTo(element);
            if (node.getData().equals(element)) { //Achei o elemento
                result += 1;
            } else { //Ainda não achei
               if (comp > 0) { //node.data > element
                result = 1 + levelAux(element, node.getLeft());
                } else {
                result = 1 + levelAux(element, node.getRight());
                }  
            }
        }
        return result;
    }

    // --- TRAVESSIAS (WALKS) ---

    public List<T> preOrder() {
        // TODO: [RAIZ] [ESQ] [DIR]
        return new ArrayList<>();
    }

    public List<T> order() {
        // TODO: [ESQ] [RAIZ] [DIR] -> Resulta nos elementos ordenados
        return new ArrayList<>();
    }

    public List<T> postOrder() {
        // TODO: [ESQ] [DIR] [RAIZ]
        return new ArrayList<>();
    }

    // --- MÉTODOS AVANÇADOS / ESPECIAIS ---

    public T sucessor(T valor) {
        // TODO: Menor elemento dentre os maiores que 'valor'
        return null;
    }

    public T predecesor(T valor) {
        // TODO: Maior elemento dentre os menores que 'valor'
        return null;
    }

    public void mirror() {
        // TODO: Inverter todos os filhos esquerdos com os direitos (Recursivo)
    }

    public int countLeaves() {
        // TODO: Contar apenas nós que não têm filhos (left e right são Nil)
        return 0;
    }

    public boolean isFull() {
        // TODO: Uma árvore é cheia se todo nó tem 0 ou 2 filhos (nunca apenas 1)
        return false;
    }

    public boolean equals(BST<T> other) {
        // TODO: Verificar se duas árvores têm a mesma estrutura e valores
        return false;
    }

    public List<T> path(T element) {
        // TODO: Retornar a lista de dados da raiz até o elemento alvo
        return new ArrayList<>();
    }
}