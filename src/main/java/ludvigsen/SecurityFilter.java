

package ludvigsen;


import ludvigsen.blog.model.User;
import ludvigsen.blog.controller.LoginController;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Simple filter that checks if a user exists in the session. If not, the target url is saved, and the user is redirected
 * to the login page
 */
public class SecurityFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // nothing to initialize
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(true);

        Object userObject = session.getAttribute(LoginController.USER_SESSION_ATTRIBUTE);

        if (userObject != null && userObject instanceof User) {
            // a user is logged in, proceed
            chain.doFilter(req, resp);
        } else {
            // show login page
            session.getServletContext().getRequestDispatcher("/login").forward(req, response);
        }
    }

    public void destroy() {
        // nothing to do here
    }
}
