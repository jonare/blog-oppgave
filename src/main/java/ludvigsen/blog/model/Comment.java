

package ludvigsen.blog.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This blog is VERY simple. It consists only of comments!
 */
public class Comment implements Comparable<Comment> {

    private static AtomicInteger nextID = new AtomicInteger(0);

    private int ID;

    private User author;

    private String title;

    private String comment;

    private String homepage;

    private Date created;

    public Comment(User author, String homepage, String title, String comment) {
        this.author = author;
        this.comment = comment;
        this.title = title;
        this.created = new Date();
        this.ID = nextID.getAndIncrement();
        this.homepage = homepage;
        }

    public int getID() {
        return ID;
    }

    public User getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;       
    }

    public Date getCreated() {
        return created;
    }

    public int compareTo(Comment o) {
        return created.compareTo(o.getCreated());
    }

    public String getHomepage() {
        return homepage;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "ID=" + ID +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", created=" + created +
                '}';
    }
}
