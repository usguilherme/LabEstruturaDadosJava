public class QueueImpl<T> implements Queue<T> {

    private T[] array;
    private int tail;

    @SuppressWarnings("unchecked")
    public QueueImpl(int size) {
        this.array = (T[]) new Object[size];
        this.tail = -1;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {

        if (element == null) return;

        if (isFull()) {
            throw new QueueOverflowException();
        }

        tail++;
        array[tail] = element;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {

        T result = null;

        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        result = array[0];
        shiftLeft();
        tail--;

        return result;
    }

    @Override
    public T head() {

        T result = null;

        if (!isEmpty()) {
            result = array[0];
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        return tail == -1;
    }

    @Override
    public boolean isFull() {
        return tail == array.length - 1;
    }

    private void shiftLeft() {

        for (int i = 0; i < tail; i++) {
            array[i] = array[i + 1];
        }

        array[tail] = null;
    }
}