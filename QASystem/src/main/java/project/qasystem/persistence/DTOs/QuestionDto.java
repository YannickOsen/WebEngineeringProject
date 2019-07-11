package project.qasystem.persistence.DTOs;



import project.qasystem.persistence.model.Answer;

import java.util.List;

public class QuestionDto {
    private String userName;
    private int idQuestion;
    private boolean isAnswered;
    private boolean isSolved;
    private String title;
    private String description;
    private List<Answer> answerList;
    //TODO maybe integrate "isAnswered" into Answerlist

    public QuestionDto(String userName, int idQuestion, boolean isAnswered, boolean isSolved, String title, String description, List<Answer> answerList){
        this.userName = userName;
        this.idQuestion = idQuestion;
        this.isAnswered = isAnswered;
        this.isSolved = isSolved;
        this.title = title;
        this.description = description;
        this.answerList = answerList;
    }


    public QuestionDto(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
