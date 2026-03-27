package stack;

public interface Stack<T> {

    void push(T element) throws StackOverflowException; // empilha elemento

    T pop() throws StackUnderflowException; // remove do topo

    T top(); // retorna o topo

    boolean isEmpty(); // verifica se está vazia

    boolean isFull(); // verifica se está cheia
}