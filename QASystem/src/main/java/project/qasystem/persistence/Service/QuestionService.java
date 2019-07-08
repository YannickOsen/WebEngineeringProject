package project.qasystem.persistence.Service;

import java.util.List;

import Entities.Answer;
import project.qasystem.persistence.model.Question;
import project.qasystem.persistence.DTOs.QuestionDto;


public class QuestionService {


    public Question getQuestionById(int id) {
        return DataBaseService.getInstance().getQuestionById(id);
    }

    public void createQuestion(String title, String description, String userName) {
        DataBaseService.getInstance().insertQuestion(title, description, userName);
    }

    //TODO remove if DB variant is usable everytime.
    public void insertQuestion(String title, String description, String userName){
        DataBaseService.getInstance().insertQuestion(title, description, userName);
    }

    /**
     * gets a List of all existing Questions in the Database.
     *
     * @return a List of all existing Questions in the Database.
     */
    public List<Question> getAllQuestions() {
        return DataBaseService.getInstance().getAllQuestionS();
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
            return DataBaseService.getInstance().getQuestionListByName(name);
        }
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
    public void checkToCreateQuestion(QuestionDto userDto) {
        createQuestion(userDto.getTitle(), userDto.getDescription(), userDto.getUserName());
    }
}
