package sorting;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array != null && array.length > 0) {
            for (int i = leftIndex + 1; i <= rightIndex; i++) {
                T key = array[i];
                int j = i - 1;
                while (j >= leftIndex && array[j].compareTo(key) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = key;
            }
        }
    }
}