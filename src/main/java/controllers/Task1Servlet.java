package controllers;

import org.apache.log4j.Logger;
import task1.QuickSortParallel;
import task1.QuickSortSimple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Mordr on 13.04.2017.
 */
@WebServlet(urlPatterns = "/task1")
public class Task1Servlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Task1Servlet.class);
    private final static int ARRAY_SIZE = 10_000_000;
    private final static int NUMBER_BOUND = 100_000_001;
    private final static int OUT_STEP = 500_000;

    private void initArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(NUMBER_BOUND);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("task1 doGet");
        int[] array1 = new int[ARRAY_SIZE], array2 = new int[ARRAY_SIZE];
        initArray(array1);
        System.arraycopy(array1, 0, array2, 0, array1.length);

        long startTime = System.currentTimeMillis();
        QuickSortSimple quickSortSimple = new QuickSortSimple();
        quickSortSimple.sort(array1);
        long sortTimeMillis = System.currentTimeMillis() - startTime;
        double sortSimpleTimeS = (double) sortTimeMillis/1000;
        String sortSimpleOutputString = "";
        for(int i = 0; i < array1.length; i = i + OUT_STEP) {
            sortSimpleOutputString += array1[i] + " ";
        }

        startTime = System.currentTimeMillis();
        QuickSortParallel quickSortParallel = new QuickSortParallel();
        quickSortParallel.sort(array2);
        sortTimeMillis = System.currentTimeMillis() - startTime;
        double sortParallelTimeS = (double) sortTimeMillis/1000;
        String sortParallelOutputString = "";
        for(int i = 0; i < array2.length; i = i + OUT_STEP) {
            sortParallelOutputString += array2[i] + " ";
        }

        req.setAttribute("sortSimpleTimeS", sortSimpleTimeS);
        req.setAttribute("sortSimpleOutputString", sortSimpleOutputString);
        req.setAttribute("sortParallelTimeS", sortParallelTimeS);
        req.setAttribute("sortParallelOutputString", sortParallelOutputString);
        req.getRequestDispatcher("/task1.jsp").forward(req, resp);
    }
}
