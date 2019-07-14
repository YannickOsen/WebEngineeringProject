package project.qasystem.persistence.model;

import javax.persistence.*;


@Entity
@Table(name="Bookmarks")
public class Bookmark {


    @Id
    @Column
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="QuestionID")
    private Question question;

    @ManyToOne
    @JoinColumn(name="UserID")
    private User user;

    public Bookmark(Question question, User user) {
        this.question = question;
        this.user = user;
    }
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public Question getQuestion() {return question;}
    public void setQuestion(Question question) {this.question = question;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}
