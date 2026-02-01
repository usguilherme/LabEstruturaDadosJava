package linkedlistInterativo;

public interface LinkedList2<T> {

    int size();

    T search(T element);

    T searchPosition(int position);

    void insertFirst(T element);

    void insertLast(T element);

    void insertPosition(int position, T element);

    void removeFirst();

    void removeLast();

    void removeValue(T element);

    void removePosition(int position);

    T[] toArray();

    boolean contains(T element);

    /* ===== outros métodos podem ser adicionados aqui ===== */
}
