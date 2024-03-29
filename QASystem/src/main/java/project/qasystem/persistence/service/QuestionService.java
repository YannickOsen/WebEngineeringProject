package project.qasystem.persistence.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.qasystem.persistence.DTOs.AnswerDTO;
import project.qasystem.persistence.DTOs.QuestionDto;
import project.qasystem.persistence.model.Answer;
import project.qasystem.persistence.model.Question;
import project.qasystem.persistence.model.User;

@Service
public class QuestionService {

    @Autowired
    private DataBaseService dataBaseService = new DataBaseService();


    public Question getQuestionById(int id) {
        long idLong = Long.valueOf(id);
        return dataBaseService.getQuestionById(idLong);
    }

    public Answer getAnswerById(int id){
        long idLong = Long.valueOf(id);
        return dataBaseService.getAnswerById(idLong);
    }

    public List<AnswerDTO> getAnswerByQuestion(Question question){
        return dataBaseService.getAnswerByQuestion(question);
    }

    public void insertQuestion(String title, String description, String userName){
        dataBaseService.insertQuestion(title, description, userName);
    }

    public void insertAnswer(String username, long idQuestion, String text) {
        dataBaseService.insertAnswer(username, idQuestion, text);
    }

    public void questionSolved(int answerID){
        dataBaseService.questionSolved(answerID);
    }

    /**
     * gets a List of all existing Questions in the Database.
     *
     * @return a List of all existing Questions in the Database.
     */
    public List<QuestionDto> getAllQuestions() {
        return dataBaseService.getAllQuestions("all", "");
    }

    public List<QuestionDto> getQuestionsByTitle(String value) {
        return dataBaseService.getAllQuestions("title", value);
    }

    public List<QuestionDto> getunsolvedQuestions() {
        return dataBaseService.getAllQuestions("notsolved", "");
    }

    public List<QuestionDto> getsolvedQuestions() {
        return dataBaseService.getAllQuestions("solved", "");
    }

    public List<QuestionDto> getansweredQuestions() {
        return dataBaseService.getAllQuestions("answered", "");
    }

    public List<QuestionDto> getnotansweredQuestions() {
        return dataBaseService.getAllQuestions("notanswered", "");
    }

    public List<QuestionDto> getuserQuestions(String username) {
        return dataBaseService.getAllQuestions("myquestions", username);
    }

    /**
     * Returns a List of Questions where the name is part of the name.
     * If name left empty returns all Questions.
     *
     * @param name Name to search for; if left blank returns all Questions.
     * @return List of matching Questions; null if nothing was found.
     */
    public List<QuestionDto> getQuestionListByName(String name) {
        if (name == null || name.equals("")) {
            return getAllQuestions();
        } else {
            return null;
//            return dataBaseService.getQuestionListByName(name);
        }
    }

    public List<QuestionDto> getBookmarkedQuestions(String userName){
        return dataBaseService.getBookmarkedQuestions(userName);
    }

    public void saveBookmarkedQuestion(String id, String username) {
        dataBaseService.saveBookmarkedQuestion(id, username);
    }

}
