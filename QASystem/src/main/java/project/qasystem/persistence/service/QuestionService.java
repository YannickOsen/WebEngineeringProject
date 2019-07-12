package project.qasystem.persistence.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.qasystem.persistence.DTOs.QuestionDto;
import project.qasystem.persistence.model.Question;

@Service
public class QuestionService {

    @Autowired
    private DataBaseService dataBaseService;


    public Question getQuestionById(int id) {
        return dataBaseService.getQuestionById(id);
    }


    //TODO remove if DB variant is usable everytime.
    public void insertQuestion(String title, String description, String userName){
        dataBaseService.insertQuestion(title, description, userName);
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

    public List<QuestionDto> getuserQuestions() {
        return dataBaseService.getAllQuestions("myquestions", "");
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

}
