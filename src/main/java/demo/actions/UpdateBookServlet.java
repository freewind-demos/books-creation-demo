package demo.actions;

import demo.dao.BooksDao;
import demo.models.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            Book book = BooksDao.findById(id);
            book.setTitle(req.getParameter("title"));
            book.setDescription(req.getParameter("description"));
            BooksDao.update(book);
            resp.sendRedirect("/list-books.html?message=Operation successful");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
