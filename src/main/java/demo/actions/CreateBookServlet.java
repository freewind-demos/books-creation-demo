package demo.actions;

import demo.dao.InMemoryDao;
import demo.models.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Book book = new Book(title, description);
        InMemoryDao.save(book);
        resp.sendRedirect("/list-books.html");
    }
}
