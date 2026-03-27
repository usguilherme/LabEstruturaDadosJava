package sorting;

public class SelectionSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array != null && array.length > 0) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                int min = i;
                for (int j = i + 1; j <= rightIndex; j++) {
                    if (array[j].compareTo(array[min]) < 0) {
                        min = j;
                    }
                }
                T aux = array[i];
                array[i] = array[min];
                array[min] = aux;
            }
        }
    }
}