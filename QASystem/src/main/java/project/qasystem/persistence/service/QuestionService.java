package project.qasystem.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<Question> getAllQuestions() {
        return dataBaseService.getAllQuestionS();
    }

    /**
     * Returns a List of Questions where the name is part of the name.
     * If name left empty returns all Questions.
     *
     * @param name Name to search for; if left blank returns all Questions.
     * @return List of matching Questions; null if nothing was found.
     */
    public List<Question> getQuestionListByName(String name) {
        if (name == null || name.equals("")) {
            return getAllQuestions();
        } else {
            return dataBaseService.getQuestionListByName(name);
        }
    }


}
