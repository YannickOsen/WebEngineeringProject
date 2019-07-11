package project.qasystem.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Questions")
public class Question {

    @Id
    @Column
    private long id;

    @Column
    private String title;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name="UserId")
    private User user;

    @Column
    private Date date;

    @Column
    private boolean isAnswered;

    public Question() {}

    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public User getAuthor() { return user; }
    public void setAuthor(User user) { this.user = user; }

    public boolean getIsAnswered() {return isAnswered;}
    public void setIsAnswered(boolean isAnswered) {this.isAnswered = isAnswered;}
}