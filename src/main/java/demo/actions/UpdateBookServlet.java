package demo.actions;

import demo.dao.InMemoryDao;
import demo.models.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Book book = InMemoryDao.findBookById(id);
        book.setTitle(req.getParameter("title"));
        book.setDescription(req.getParameter("description"));
        InMemoryDao.update(book);
        resp.sendRedirect("/list-books.html");
    }
}
