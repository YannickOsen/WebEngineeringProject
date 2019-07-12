package project.qasystem.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Answers")
public class Answer {

    //TODO adapt remainder of entities.Answer elements

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name="QuestionID")
    private Question question;

    @ManyToOne
    @JoinColumn(name="UserID")
    private User user;


    @Column
    private boolean isAcceptedAnswer;

    @Column
    private Date date;

    public Answer(Question question, String text, User user) {
        this.question = question;
        this.text = text;
        this.user = user;
        this.date = new Date();
        this.isAcceptedAnswer = false;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}


    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    public Question getQuestion() {return question;}
    public void setQuestion(Question question) {this.question = question;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}


    public void setIsAcceptedAnswer(boolean isAcceptedAnswer) { this.isAcceptedAnswer = isAcceptedAnswer;  }
}
