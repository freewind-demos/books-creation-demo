package demo.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("demo".equals(username) && "123456".equals(password)) {
            req.getSession().setAttribute("username", username);
            System.out.println("Session username: " + username);
            resp.sendRedirect("/list-books.html");
        } else {
            resp.sendRedirect("/login.html?message=Invalid username or password");
        }
    }
}
