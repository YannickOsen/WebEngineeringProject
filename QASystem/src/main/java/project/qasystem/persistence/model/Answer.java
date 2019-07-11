package project.qasystem.persistence.model;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;

@Entity
@Table(name="Answers")
public class Answer {

    //TODO adapt remainder of entities.Answer elements

    @Id
    @Column
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


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    public Question getQuestion() {return question;}
    public void setQuestion(Question question) {this.question = question;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public boolean getIsAcceptedAnswer() {return isAcceptedAnswer;}
    public void setIsAcceptedAnswer(boolean isAcceptedAnswer) {this.isAcceptedAnswer = isAcceptedAnswer;}
}
