package task1;

/**
 * Created by Mordr on 12.04.2017.
 */
public class QuickSortSimple {
    private int[] array;

    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.array = array;
        doSort(0, this.array.length - 1);
    }

    private void doSort(int start, int end) {
        int i = start, j = end;
        int middle = array[i + (j - i)/2];

        while (i <= j) {
            while (array[i] < middle) {
                i++;
            }
            while (array[j] > middle) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (start < j) {
            doSort(start, j);
        }
        if (i < end) {
            doSort(i, end);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
