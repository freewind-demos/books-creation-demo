package demo.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginCheckFilter implements Filter {

    private List<String> publicPaths;

    public void init(FilterConfig filterConfig) throws ServletException {
        String publicPathsStr = filterConfig.getInitParameter("public-paths");
        publicPaths = trimItems(Arrays.asList(publicPathsStr.split(",")));
    }

    private List<String> trimItems(List<String> items) {
        List<String> list = new ArrayList<String>();
        for (String item : items) {
            list.add(item.trim());
        }
        return list;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (isPublicPath(request) || isLoggedIn(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/login.html?message=Please login first");
        }
    }

    private boolean isPublicPath(HttpServletRequest request) {
        String currentPath = request.getServletPath();
        return publicPaths.contains(currentPath);
    }

    private boolean isLoggedIn(HttpServletRequest request) {
        return request.getSession().getAttribute("username") != null;
    }

    public void destroy() {

    }
}
