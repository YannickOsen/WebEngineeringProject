package project.qasystem.persistence.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import project.qasystem.persistence.model.User;
import org.springframework.stereotype.Service;
import project.qasystem.persistence.model.Answer;
import project.qasystem.persistence.model.Question;
import project.qasystem.persistence.model.User;
import project.qasystem.persistence.repositories.AnswerRepository;
import project.qasystem.persistence.repositories.QuestionRepository;
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
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

   @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
   
    public Question getQuestionById(long id){
        return questionRepository.findById(id);
    }


    public Answer getAnswerById(long id){
        return answerRepository.findById(id);
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

    public void insertQuestion(String title, String text, String userName){
        User user = userRepository.findByUsername(userName);
        Question question = new Question(title, text, user);
        questionRepository.save(question);
    }

    public void insertAnswer(long questionId, String text, String userName){
        Question question = questionRepository.findById(questionId);
        User user = userRepository.findByUsername(userName);
        Answer answer = new Answer(question, text, user);
        answerRepository.save(answer);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    /**
     * Looks for questions with a specific String in its title/username.
     * @param search The string to be searched for.
     * @return The list of questions containing the searched string.
     */
    public List<Question> getQuestionListByName(String search) {
        List<Question> resultList = null;
        if (search != null && !search.isEmpty()) {
            User user = userRepository.findByUsername(search);
            resultList.addAll(questionRepository.findByUser(user));
            resultList.addAll(questionRepository.findByTitle(search));
        }
        return resultList;
    }

    /**
     * Adds the Answer to the answered Questions answerList
     * Marks the Question as Answered
     *
     * @param answerID ID of the answer that tries +to solve this question.
    */
    public void addAnswer(int answerID){
        Answer currentAnswer = getAnswerById(answerID);
        Question answeredQuestion = currentAnswer.getQuestion();
        answeredQuestion.setIsAnswered(true);
    }

    /**
     * Adds the Answer to the answered Questions answerList
     * Marks the Question as Answered
     *
     * @param answerId ID of the answer that solved this question.
     * */
    public void questionSolved(int answerId){
        getAnswerById(answerId).setIsAcceptedAnswer(true);
        getAnswerById(answerId).getQuestion().setIsAnswered(true);
    }


}
