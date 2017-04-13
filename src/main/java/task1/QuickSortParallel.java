package task1;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Mordr on 12.04.2017.
 */
public class QuickSortParallel {
    private final static Logger LOGGER = Logger.getLogger(QuickSortParallel.class);
    private final static int THREAD_MAX = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);

    public void sort(int[] input) {
        final AtomicInteger threadCount = new AtomicInteger(1);
        executorService.execute(new QuickSortRunnable(input, 0, input.length - 1, threadCount));
        try {
            synchronized (threadCount) {
                threadCount.wait();
            }
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }


    private static class QuickSortRunnable implements Runnable {
        private final int[] array;
        private final int start;
        private final int end;
        private final AtomicInteger threadCount;

        public QuickSortRunnable(int[] array, int start, int end, AtomicInteger threadCount) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.threadCount = threadCount;
        }

        @Override
        public void run() {
            doSort(start, end);
            synchronized (threadCount) {
                if (threadCount.getAndDecrement() == 1) {
                    threadCount.notify();
                }
            }
        }

        private void doSort(int start, int end) {
            if (start < end) {
                int storeIndex = doPartitionSort(start, end);
                if (threadCount.get() >= THREAD_MAX) {
                    doSort(start, storeIndex - 1);
                    doSort(storeIndex, end);
                } else {
                    threadCount.getAndAdd(2);
                    executorService.execute(new QuickSortRunnable(array, start, storeIndex - 1, threadCount));
                    executorService.execute(new QuickSortRunnable(array, storeIndex, end, threadCount));
                }
            }
        }

        private int doPartitionSort(int start, int end) {
            int i = start, j = end;
            int middle = array[i + (j - i)/2];

            while (i <= j) {
                while (array[j] > middle) {
                    j--;
                }
                while (array[i] < middle) {
                    i++;
                }

                if (i <= j) {
                    swap(i, j);
                    i++;
                    j--;
                }
            }
            return i;
        }

        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
