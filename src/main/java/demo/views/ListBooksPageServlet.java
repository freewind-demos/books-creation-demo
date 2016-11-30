package demo.views;

import demo.dao.InMemoryDao;
import demo.models.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListBooksPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = InMemoryDao.getBooks();
        request.setAttribute("message", request.getParameter("message"));
        request.setAttribute("books", books);
        request.getRequestDispatcher("/WEB-INF/pages/list.jsp").forward(request, response);
    }

}
