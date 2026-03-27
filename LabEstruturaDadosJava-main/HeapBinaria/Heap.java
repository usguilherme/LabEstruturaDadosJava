package HeapBinaria;

public interface Heap<T extends Comparable<T>> {

    boolean isEmpty(); // Verifica se o heap está vazio

    int size(); // Retorna a quantidade de elementos no heap

    T rootElement(); // Retorna o elemento da raiz do heap

    void insert(T element); // Insere um elemento no heap

    T extractRootElement(); // Remove e retorna o elemento da raiz

    void buildHeap(T[] array); // Constrói o heap a partir de um array

    T[] toArray(); // Retorna os elementos do heap em forma de array
}