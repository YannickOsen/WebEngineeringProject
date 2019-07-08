package project.qasystem.persistence.Service;

import Entities.Answer;

public class AnswerService {

    public Answer getAnswerById(int id) {
        return DataBaseService.getInstance().getAnswerById(id);
    }


    public void insertAnswer(int questionID, String answerContent, String userNameAnswering){
        DataBaseService.getInstance().insertAnswer(questionID, answerContent, userNameAnswering);
    }


}
