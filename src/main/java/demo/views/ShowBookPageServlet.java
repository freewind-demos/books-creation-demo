package demo.views;

import demo.dao.BooksDao;
import demo.models.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ShowBookPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            Book book = BooksDao.findById(id);
            request.setAttribute("book", book);
            request.getRequestDispatcher("/WEB-INF/pages/show.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

}
