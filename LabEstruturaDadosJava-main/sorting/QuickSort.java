package sorting;

public class QuickSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array != null && array.length > 0 && leftIndex < rightIndex) {
            int pivot = partition(array, leftIndex, rightIndex);
            sort(array, leftIndex, pivot - 1);
            sort(array, pivot + 1, rightIndex);
        }
    }

    private int partition(T[] array, int left, int right) {
        T pivot = array[left];
        int i = left + 1;
        for (int j = left + 1; j <= right; j++) {
            if (array[j].compareTo(pivot) < 0) {
                T aux = array[i];
                array[i] = array[j];
                array[j] = aux;
                i++;
            }
        }
        T aux = array[left];
        array[left] = array[i - 1];
        array[i - 1] = aux;
        return i - 1;
    }
}