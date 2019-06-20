

package ludvigsen.blog.controller;

import ludvigsen.blog.database.Database;
import ludvigsen.blog.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * The edit function is really simple.
 *
 * If an admin finds a comment that needs editing, he replaces the text with a short notice:
 *
 * 'Comment is edited and anonymised!'
 */
@Controller
public class EditController {

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editComment(HttpServletRequest req) throws ServletException, IOException {
        int commentID = Integer.parseInt(req.getParameter("commentID"));
        Comment c = Database.getComment(commentID);
        String title = c.getTitle();
        c.setTitle(title + " - edited");
        c.setComment("Comment is edited and anonymised!");


        return "redirect:/blog"; //redirect to BlogController
    }
}
