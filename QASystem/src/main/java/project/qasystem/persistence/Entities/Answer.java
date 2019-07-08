package project.qasystem.persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name="Answers")
public class Answer {

    //TODO adapt remainder of Entities.Answer elements

    @Id
    @Column
    private int id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name="QuestionID")
    private project.qasystem.persistence.Entities.Question question;

    @ManyToOne
    @JoinColumn(name="UserID")
    private User user;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    public project.qasystem.persistence.Entities.Question getQuestion() {return question;}
    public void setQuestion(Question question) {this.question = question;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}


}
