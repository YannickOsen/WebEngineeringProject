package project.qasystem.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Questions")
public class Question {

    @Id
    @Column
    @GeneratedValue
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

    @Column
    private boolean isSolved;

    public Question(String title, String text, User user) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.user = user;
        this.date = new Date();
        this.isAnswered = false;
        this.isSolved = false;

    }

    public Question() {

    }

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

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public boolean getIsAnswered() {return isAnswered;}
    public void setIsAnswered(boolean isAnswered) {this.isAnswered = isAnswered;}

    public boolean getIsSolved() {return isSolved;}
    public void setIsSolved(boolean isSolved) {this.isSolved = isSolved;}


}