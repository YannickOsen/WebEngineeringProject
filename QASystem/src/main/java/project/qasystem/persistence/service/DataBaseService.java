package project.qasystem.persistence.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import project.qasystem.persistence.model.User;
import org.springframework.stereotype.Service;
import project.qasystem.persistence.DTOs.QuestionDto;
import project.qasystem.persistence.model.Answer;
import project.qasystem.persistence.model.Question;
import project.qasystem.persistence.model.User;
import project.qasystem.persistence.repositories.AnswerRepository;
import project.qasystem.persistence.repositories.QuestionRepository;
import project.qasystem.persistence.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public void insertUser(String userName, String passWord){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(bCryptPasswordEncoder.encode(passWord));
        userRepository.save(user);
    }

    public User getUserByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public void insertQuestion(String title, String text, String userName){
        User user = userRepository.findByUsername(userName);
        Question question = new Question(title, text, user);
        questionRepository.save(question);
    }

    public void insertAnswer(String username, long idQuestion, String text){
        Question question = questionRepository.findById(idQuestion);
        User user = userRepository.findByUsername(username);
        Answer answer = new Answer(question, text, user);
        answerRepository.save(answer);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<QuestionDto> getAllQuestions(String search, String input){
        List<QuestionDto> questionDtos = new ArrayList<>();
        List<Question> questions = null;
        switch (search) {
            case "all": questions = questionRepository.findAll();
                        break;
            case "title": questions = questionRepository.findByTitle(input);
                            break;
            case "solved": questions = questionRepository.findByIsSolved(true);
                            break;
            case "notsolved": questions = questionRepository.findByIsSolved(false);
                               break;
            case "answered": questions = questionRepository.findByIsAnswered(true);
                             break;
            case "notanswered": questions = questionRepository.findByIsAnswered(false);
                                break;
            case "myquestions":
                               User user = userRepository.findByUsername(input);
                               questions = questionRepository.findByUser(user);
                                  ;
        }

        QuestionDto questionDto;
        for (Question question: questions) {
            questionDto = new QuestionDto();
            questionDto.setTitle(question.getTitle());
            questionDto.setDescription(question.getText());
            questionDto.setAnswered(question.getIsAnswered());
            questionDto.setSolved(question.getIsSolved());
            questionDto.setUserName(question.getUser().getUsername());
            questionDto.setDate(question.getDate());
            questionDto.setIdQuestion(Math.toIntExact(question.getId()));
            questionDtos.add(questionDto);
        }
        return questionDtos;
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
