package controllers;

import org.apache.log4j.Logger;
import task1.QuickSortSimple;
import task4.SortedArrayMerger;

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
@WebServlet(urlPatterns = "/task4")
public class Task4Servlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Task4Servlet.class);
    private final static int ARRAY_SIZE1 = 100;
    private final static int ARRAY_SIZE2 = 200;
    private final static int NUMBER_BOUND = 300;

    private void initArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(NUMBER_BOUND);
        }
    }

    private String arrayToString(int[] array) {
        String arrayStr = "";
        for (int item : array) {
            arrayStr += item + " ";
        }
        return arrayStr;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("task4 doGet");
        int[] array1 = new int[ARRAY_SIZE1], array2 = new int[ARRAY_SIZE2];
        initArray(array1);
        initArray(array2);

        QuickSortSimple quickSortSimple = new QuickSortSimple();
        quickSortSimple.sort(array1);
        quickSortSimple.sort(array2);

        String array1Str = arrayToString(array1);
        String array2Str = arrayToString(array2);

        SortedArrayMerger sortedArrayMerger = new SortedArrayMerger();
        int[] array3 = sortedArrayMerger.merge(array1, array2);

        String array3Str = arrayToString(array3);

        req.setAttribute("array1Str", array1Str);
        req.setAttribute("array2Str", array2Str);
        req.setAttribute("array3Str", array3Str);
        req.getRequestDispatcher("/task4.jsp").forward(req, resp);
    }
}
