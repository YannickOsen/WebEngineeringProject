package project.qasystem.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {

    @Id
    @Column
    private long id;

    @Column(name="Username")
    private String username;

    @Column
    private String password;

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
