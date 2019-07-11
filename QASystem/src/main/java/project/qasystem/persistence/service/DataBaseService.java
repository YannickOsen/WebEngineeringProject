package project.qasystem.persistence.service;


import entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import project.qasystem.persistence.model.User;
import org.springframework.stereotype.Service;
import project.qasystem.persistence.model.Question;
import project.qasystem.persistence.model.User;
import project.qasystem.persistence.repositories.UserRepository;

import java.util.List;

/**
 * Singleton Data Access Object which handles all queries with the Database.
 */
@Service
public class DataBaseService {

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
/**    public static DataBaseService getInstance() {
        if (instance == null) {
            instance = new DataBaseService();
            return instance;
        } else {
            return instance;
        }
    }
 **/

    public Question getQuestionById(int id){
        //TODO connection to DB
        return null;
    }


    public Answer getAnswerById(int id){
        //TODO connection to DB
        Answer answer = new Answer();
        return answer;
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

    /**
     * Adds the Answer to the answered Questions answerList
     * Marks the Question as Answered
     *
     * @param answerID ID of the answer that tries +to solve this question.

    public void addAnswer(int answerID){
        Answer currentAnswer = getAnswerById(answerID);
        Question answeredQuestion = getQuestionById(currentAnswer.getIdQuestion());
        answeredQuestion.setAnswered(true);
        List<Answer> currentAnswerList = answeredQuestion.getAnswerList();
        currentAnswerList.set(currentAnswerList.size(),getAnswerById(answerID)) ;
        //TODO update question back to databse
    }
     */
    /**
     * Adds the Answer to the answered Questions answerList
     * Marks the Question as Answered
     *
     * @param answerID ID of the answer that solved this question.
    public void questionSolved(int answerID){
        getAnswerById(answerID).setAcceptedAnswer(true);
        getQuestionById(getAnswerById(answerID).getIdQuestion()).setAnswered(true);
    }

     */
}