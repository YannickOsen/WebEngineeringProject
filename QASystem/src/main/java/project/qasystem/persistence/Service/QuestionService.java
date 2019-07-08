package project.qasystem.persistence.Service;

import java.util.List;

import project.qasystem.persistence.model.Question;


public class QuestionService {


    public Question getQuestionById(int id) {
        return DataBaseService.getInstance().getQuestionById(id);
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


}
