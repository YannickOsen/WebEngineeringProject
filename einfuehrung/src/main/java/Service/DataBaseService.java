package Service;


import Entities.Answer;
import Entities.Question;
import Entities.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Singleton Data Access Object which handles all queries with the Database.
 */
public class DataBaseService {

    private static DataBaseService instance;


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
        //TODO insert User into DataBase
    }

    public User getUserByUserName(String Username){
        //TODO insert User into DataBase
        return null;
    }

    public void setAdvancedUserData(/*Content*/){
        //TODO Questions/Answers of this user?
        //propably not needed, can be removed
    }

    public void insertQuestion(String title, String description, String userName){
        //TODO DB connection; Maybe needs answers
    }

    public void insertAnswer(int questionID, String answerContent, String userNameAnswering){

        //TODO DB connection, which should generate answerID;
        //addAnswer(answerID);
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
     */
    public void addAnswer(int answerID){
        Answer currentAnswer = getAnswerById(answerID);
        Question answeredQuestion = getQuestionById(currentAnswer.getIdQuestion());
        answeredQuestion.setAnswered(true);
        List<Answer> currentAnswerList = answeredQuestion.getAnswerList();
        currentAnswerList.set(currentAnswerList.size(),getAnswerById(answerID)) ;
        //TODO update question back to databse
    }

    /**
     * Adds the Answer to the answered Questions answerList
     * Marks the Question as Answered
     *
     * @param answerID ID of the answer that solved this question.
     */
    public void qustionSolved(int answerID){
        getAnswerById(answerID).setAcceptedAnswer(true);
        getQuestionById(getAnswerById(answerID).getIdQuestion()).setAnswered(true);
    }
}
