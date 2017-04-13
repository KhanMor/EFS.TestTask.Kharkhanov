package controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mordr on 13.04.2017.
 */
@WebServlet(urlPatterns = "/task3")
public class Task3Servlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Task1Servlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("task3 doGet");
        req.getRequestDispatcher("/task3.jsp").forward(req, resp);
    }
}
