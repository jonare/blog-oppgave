

package ludvigsen.blog.controller;

import ludvigsen.blog.database.Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AdminController {

    @RequestMapping(value = {"/admin", "/blog/admin"}, method = RequestMethod.GET)
    public String deleteComment(HttpServletRequest request) throws ServletException, IOException {
        // check if we should delete a comment:
        String commentToDelete = request.getParameter("commentToDelete");
        if (commentToDelete != null) {
            Database.deleteComment(Integer.parseInt(commentToDelete));
        }
        return "redirect:/blog"; //redirect to BlogController
    }
}
