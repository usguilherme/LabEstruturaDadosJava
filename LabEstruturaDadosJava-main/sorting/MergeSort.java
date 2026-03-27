package sorting;

public class MergeSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array != null && array.length > 0 && leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            sort(array, leftIndex, mid);
            sort(array, mid + 1, rightIndex);
            merge(array, leftIndex, mid, rightIndex);
        }
    }
    private void merge(T[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (((T) leftArray[i]).compareTo((T) rightArray[j]) <= 0) {
                array[k] = (T) leftArray[i];
                i++;
            } else {
                array[k] = (T) rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = (T) leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = (T) rightArray[j];
            j++;
            k++;
        }
    }
}