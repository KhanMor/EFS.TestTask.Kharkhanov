package task4;

/**
 * Created by Mordr on 13.04.2017.
 */
public class SortedArrayMerger {

    public int[] merge(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;

        int[] result = new int[len1 + len2];

        int i = 0, j = 0, k = 0;

        while (i < len1 && j < len2) {
            if (array1[i] <= array2[j]) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }
        if (i < len1) {
            System.arraycopy(array1, i, result, k, len1 - i);
        } else {
            System.arraycopy(array2, j, result, k, len2 - j);
        }

        return result;
    }
}
