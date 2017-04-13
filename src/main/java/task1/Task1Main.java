package task1;

import java.util.Random;

/**
 * Created by Mordr on 12.04.2017.
 */
public class Task1Main {
    private final static int ARRAY_SIZE = 10_000_000;
    private final static int NUMBER_BOUND = 100_000_001;
    private final static int OUT_STEP = 500_000;

    public static void main(String[] args) {
        int[] array1 = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(NUMBER_BOUND);
        }
        int[] array2 = new int[ARRAY_SIZE];
        System.arraycopy(array1, 0, array2, 0, array1.length);

        doSimpleQuickSort(array1);
        System.out.println();
        doParallelQuickSort(array2);
    }

    private static void doSimpleQuickSort(int[] array) {
        long startTime = System.currentTimeMillis();

        QuickSortSimple quickSortSimple = new QuickSortSimple();
        quickSortSimple.sort(array);

        long sortTimeMillis = System.currentTimeMillis() - startTime;
        double sortTimeS = (double) sortTimeMillis/1000;

        System.out.println("Time for simple quick sort array is " + sortTimeS + " sec. Sorted sequence: ");
        for(int i = 0; i < array.length; i = i + OUT_STEP) {
            System.out.print(array[i] + " ");
        }
    }

    private static void doParallelQuickSort(int[] array) {
        long startTime = System.currentTimeMillis();
        QuickSortParallel quickSortParallel = new QuickSortParallel();
        quickSortParallel.sort(array);
        quickSortParallel.shutdown();
        long sortTimeMillis = System.currentTimeMillis() - startTime;
        double sortTimeS = (double) sortTimeMillis/1000;

        System.out.println("Time for parallel quick sort array is " + sortTimeS + " sec. Sorted sequence: ");
        for(int i = 0; i < array.length; i = i + OUT_STEP) {
            System.out.print(array[i] + " ");
        }
    }
}
