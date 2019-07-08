package DTOs;

import sun.font.TrueTypeFont;

public class RegistrationDto {

    private String userName;

    private String password;

    private String confirmPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String email) {
        this.userName = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void userNameTest() {
        if (this.userName != null) {
            //TODO check if username already exists with UserService.checkToCreateUser
            if (true) {
                throw new IllegalArgumentException("UserName is already taken");
            }
        } else {
            throw new IllegalArgumentException("No UserName name provided!");
        }
    }


}