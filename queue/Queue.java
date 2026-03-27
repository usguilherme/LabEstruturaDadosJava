public interface Queue<T> {

    void enqueue(T element) throws QueueOverflowException; // insere no final

    T dequeue() throws QueueUnderflowException; // remove do início

    T head(); // retorna o primeiro elemento

    boolean isEmpty(); // verifica se a fila está vazia

    boolean isFull(); // verifica se a fila está cheia
}