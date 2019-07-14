package project.qasystem.persistence.DTOs;

public class UserDto {

    private String userName;
    private String password;

    public String getUserName() {return userName;}
    public String getPassword() {return password;}

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserName(String email) {
        this.userName = email;
    }
}
