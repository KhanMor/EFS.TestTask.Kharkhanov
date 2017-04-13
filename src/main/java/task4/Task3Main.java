package task4;

import task1.QuickSortSimple;

import java.util.Random;

/**
 * Created by Mordr on 13.04.2017.
 */
public class Task3Main {
    private final static int ARRAY_SIZE1 = 100;
    private final static int ARRAY_SIZE2 = 200;
    private final static int NUMBER_BOUND = 300;

    public static void main(String[] args) {
        Random random = new Random();

        int[] array1 = new int[ARRAY_SIZE1];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(NUMBER_BOUND);
        }

        int[] array2 = new int[ARRAY_SIZE2];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = random.nextInt(NUMBER_BOUND);
        }

        QuickSortSimple quickSortSimple = new QuickSortSimple();
        quickSortSimple.sort(array1);
        quickSortSimple.sort(array2);

        System.out.println("array1: ");
        for (int item : array1) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("array2: ");
        for (int item : array2) {
            System.out.print(item + " ");
        }

        SortedArrayMerger sortedArrayMerger = new SortedArrayMerger();
        int[] array3 = sortedArrayMerger.merge(array1, array2);

        System.out.println();
        System.out.println("array3: ");
        for (int item : array3) {
            System.out.print(item + " ");
        }
    }
}
