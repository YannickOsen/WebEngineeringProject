package project.qasystem.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.qasystem.persistence.DTOs.*;
//import project.qasystem.persistence.entities.*;
import project.qasystem.persistence.model.Question;
import project.qasystem.persistence.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private DataBaseService dataBaseService;

    private String currentUser = "default";
    /**
     * returns a user with the given userName, null if not found.
     *
     * @param userName userName to look for.
     * @return user with the userName.
     */
    public User getUserByUserName(String userName) {
        return dataBaseService.getUserByUserName(userName);
    }

    /**
     * Creates a user with the given parameter. first and last name may be null.
     *
     * @param userName userName of the user.
     * @param password encoded password.
     */
    public void createUser(String userName, String password) {
        dataBaseService.insertUser(userName, password);
    }

    /**
     * This method is used for registration. It checks whether an userName is valid, if the given passwords match
     * and if the userName isn't already registered. When there is no error, it creates a new User in the Database.
     *
     * @param userDto A user Data Transfer Object is used to provide the method with userName, password, and
     *                a second password (needs to be equal to first password).
     * @return It returns an error message as String if the given values can't meet the requirements of the method.
     * Otherwise the returned String is empty.
     */
    public String checkToCreateUser(RegistrationDto userDto) {
        String errorMessage = "";
        String userName = userDto.getUserName();
        String password = userDto.getPassword();
        String confirmPassword = userDto.getConfirmPassword();
        if (!password.equals(confirmPassword)) {                 //check if both passwords are equal
            errorMessage = "Passwörter müssen übereinstimmen!";
        } else if (getUserByUserName(userName) != null) {                     //check if email isn't already registered
            errorMessage = "UserName: '" + userName + "' existiert bereits!";
        } else {
            createUser(userName, password);
        }
        return errorMessage;
    }

    /**
     * returns a list of all users in the system.
     *
     * @return a list of all users in the system.
     */
    public List<User> getAllUsers() {
        return dataBaseService.getAllUsers();
    }


    public String getCurrentUser() {return currentUser;}

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}
