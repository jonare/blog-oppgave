

package ludvigsen.blog.controller;

import ludvigsen.blog.database.Database;
import ludvigsen.blog.model.Comment;
import ludvigsen.blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the main page, and serves the comments get requests, and add comments on post requests.
 */
@Controller
public class BlogController {

    @RequestMapping(value = {"/", "/blog"}, method = RequestMethod.GET)
    public String showBlog(Model model, HttpServletResponse response) {
        model.addAttribute("comments", Database.getComments());

        response.setHeader("Content-Security-Policy", "script-src 'nonce-1234' 'strict-dynamic'");
        return "blog";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.POST)
    public String addComment(HttpServletRequest request) {
        String title = request.getParameter("title");
        String comment = request.getParameter("comment");
        String homepage = request.getParameter("homepage");

        User user = (User) request.getSession(true).getAttribute("USER");
        Database.addComment(new Comment(user, homepage, title, comment));

        return "redirect:/blog"; //redirect to avoid double postings
    }
}
