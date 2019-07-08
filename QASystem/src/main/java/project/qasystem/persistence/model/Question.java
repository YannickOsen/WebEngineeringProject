package project.qasystem.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="Questions")
public class Question {

    @Id
    @Column
    private int id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name="UserId")
    private User user;

    public Question() {}

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public User getAuthor() { return user; }

    public void setAuthor(User user) { this.user = user; }
}