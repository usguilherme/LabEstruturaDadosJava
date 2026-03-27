package sorting;

public class BubbleSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array != null && array.length > 0) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                for (int j = leftIndex; j < rightIndex; j++) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        T aux = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = aux;
                    }
                }
            }
        }
    }
}