

package ludvigsen.blog.database;

import ludvigsen.blog.model.Comment;
import ludvigsen.blog.model.User;

import javax.servlet.ServletException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * This blog system uses a very basic in-memory database, consisting of a map og users, and a set of comments.
 */
public class Database {

    private static final Set<Comment> comments = Collections.synchronizedSet(new TreeSet<Comment>());

    static {
        User user = AccountsRepository.loadUser("username");
        comments.add(new Comment(user, "http://www.google.com/", "Test message", "This is a test message, already residing in the database."));
    }

    public static Comment getComment(int ID) throws ServletException {
        for (Comment comment : comments) {
            if (ID == comment.getID()) {
                return comment;
            }
        }
        throw new ServletException("Comment with ID=" + ID + " not found. Program error or failed attack?");
    }

    public static void deleteComment(int ID) throws ServletException {
        Comment comment = getComment(ID);
        comments.remove(comment);
    }

    public static void addComment(Comment comment) {
        comments.add(comment);
    }

    public static Set<Comment> getComments() {
        return comments;
    }
}
