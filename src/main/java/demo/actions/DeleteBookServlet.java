package demo.actions;

import demo.dao.BooksDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            BooksDao.deleteById(id);
            resp.sendRedirect("/list-books.html?message=Operation successful");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

}
