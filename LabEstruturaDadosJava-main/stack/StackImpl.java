package stack;

public class StackImpl<T> implements Stack<T> {

    private T[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public StackImpl(int size) {
        this.array = (T[]) new Object[size];
        this.top = -1;
    }

    @Override
    public void push(T element) throws StackOverflowException {

        if (element == null) return;

        if (isFull()) {
            throw new StackOverflowException();
        }

        top++;
        array[top] = element;
    }

    @Override
    public T pop() throws StackUnderflowException {

        T result = null;

        if (isEmpty()) {
            throw new StackUnderflowException();
        }

        result = array[top];
        array[top] = null;
        top--;

        return result;
    }

    @Override
    public T top() {

        T result = null;

        if (!isEmpty()) {
            result = array[top];
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == array.length - 1;
    }
}
