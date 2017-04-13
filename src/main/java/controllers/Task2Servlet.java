package controllers;

import org.apache.log4j.Logger;
import task2.jaxb.XmlHumansWrapper;
import task2.pojo.Human;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mordr on 13.04.2017.
 */
@WebServlet(urlPatterns = "/task2")
public class Task2Servlet extends HttpServlet{
    private static final Logger LOGGER = Logger.getLogger(Task2Servlet.class);
    private final static String XML_FILE_PATH = "/WEB-INF/classes/humans.xml";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("task2 doGet");
        ServletContext servletContext = getServletContext();
        String filePath = servletContext.getRealPath(XML_FILE_PATH);

        XmlHumansWrapper xmlHumansWrapper = new XmlHumansWrapper();
        xmlHumansWrapper = (XmlHumansWrapper) xmlHumansWrapper.xmlUnMarshall(filePath);
        List<Human> humans = xmlHumansWrapper.getHumans();
        req.setAttribute("humans", humans);

        req.getRequestDispatcher("/task2.jsp").forward(req, resp);
    }
}
