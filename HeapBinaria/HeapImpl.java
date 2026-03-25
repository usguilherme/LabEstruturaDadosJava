package HeapBinaria;

public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

    protected T[] heap;
    protected int size;

    public HeapImpl(int capacity) {
        heap = (T[]) new Comparable[capacity];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T rootElement() {
        T result = null;
        if (!isEmpty()) {
            result = heap[0];
        }
        return result;
    }

    @Override
    public void insert(T element) {
        if (element != null && size < heap.length) {
            heap[size] = element;
            heapifyUp(size);
            size++;
        }
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        if (index > 0 && heap[index].compareTo(heap[parent]) > 0) {
            T temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            heapifyUp(parent);
        }
    }

    @Override
    public T extractRootElement() {
        T result = null;

        if (!isEmpty()) {
            result = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = null;
            size--;

            heapifyDown(0);
        }

        return result;
    }

    private void heapifyDown(int index) {

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < size && heap[left].compareTo(heap[largest]) > 0) {
            largest = left;
        }

        if (right < size && heap[right].compareTo(heap[largest]) > 0) {
            largest = right;
        }

        if (largest != index) {
            T temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;

            heapifyDown(largest);
        }
    }

    @Override
    public void buildHeap(T[] array) {
        if (array != null) {

            heap = (T[]) new Comparable[array.length];
            size = array.length;

            for (int i = 0; i < array.length; i++) {
                heap[i] = array[i];
            }

            for (int i = (size / 2) - 1; i >= 0; i--) {
                heapifyDown(i);
            }
        }
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Comparable[size];

        for (int i = 0; i < size; i++) {
            result[i] = heap[i];
        }

        return result;
    }
}