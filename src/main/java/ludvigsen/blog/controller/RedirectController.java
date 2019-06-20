

package ludvigsen.blog.controller;

import ludvigsen.blog.database.ClickStats;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet that redirects the user to a given URL
 */
@Controller
public class RedirectController {

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getParameter("url");

        ClickStats.addClick(url);

        resp.sendRedirect(url);
    }
}