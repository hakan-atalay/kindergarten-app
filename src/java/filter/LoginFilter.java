package filter;

import entity.User;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

        User u = (User) req.getSession().getAttribute("valid_user");

        if (u == null) {

            if (url.contains("panel") || url.contains("logout")) {
                res.sendRedirect(req.getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }

        } else {

            if (url.contains("register") || url.contains("login")) {
                res.sendRedirect(req.getContextPath() + "/panel/ogrenciler/list.xhtml");
            } else if (url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            } else {
                chain.doFilter(request, response);
            }

        }

    }

}
