package project.qasystem.persistence.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import project.qasystem.persistence.Entities.Question;
//import project.qasystem.persistence.Entities.User;
import project.qasystem.persistence.model.User;
import project.qasystem.persistence.repositories.UserRepository;

import java.util.LinkedList;
import java.util.List;

/**
 * Singleton Data Access Object which handles all queries with the Database.
 */
public class DataBaseService {

    private static DataBaseService instance;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * Returns the Instance of this Singleton.
     * If there is none a Instance is created.
     *
     * @return Instance of this Singleton.
     */
    public static DataBaseService getInstance() {
        if (instance == null) {
            instance = new DataBaseService();
            return instance;
        } else {
            return instance;
        }
    }

    public Question getQuestionById(int id){
        //TODO connection to DB
        return null;
    }

    public void createTables(){
        /*TODO change to return Table type
            * Grab Table of Questions
         */
    }

    public void insertUser(String userName, String passWord){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(bCryptPasswordEncoder.encode(passWord));
        userRepository.save(user);
    }

    public User getUserByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public void setAdvancedUserData(/*Content*/){
        //TODO Questions/Answers of this user
    }

    public void insertQuestion(String title, String description, String userName){
        //TODO DB connection; Maybe needs answers
    }

    public void insertAnswer(int questionID, String answerContent, String userNameAnswering){
        //TODO DB connection;
    }

    public List<User> getAllUsers(){
        //TODO DB connection;
        return null;
    }

    public List<Question> getAllQuestionS(){
        return null;
        //TODO DB
    }


    public List<Question> getQuestionListByName(String name) {
        if (name != null && !name.isEmpty()) {
            //TODO DB
        }
        return null;
    }
}
