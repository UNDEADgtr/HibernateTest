package by.undead.app.servlet;

import by.undead.app.dao.BaseDao;
import by.undead.app.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 16.01.13
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
public class Book extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO bookDao = new BaseDao(Book.class);

        Book book = new Book();

        //book.setTitle


        String url = "WEB-INF/jsp/book.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
