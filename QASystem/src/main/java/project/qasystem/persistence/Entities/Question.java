package project.qasystem.persistence.Entities;

public class Question {

    private String userName;
    private int idQuestion;
    private boolean isAnswered;
    private boolean isSolved;
    private String title;
    private String description;


    //TODO maybe add Answers?
    public Question(String userName, int idQuestion, boolean isAnswered, boolean isSolved, String title, String description){
        this.userName = userName;
        this.idQuestion = idQuestion;
        this.isAnswered = isAnswered;
        this.isSolved = isSolved;
        this.title = title;
        this.description = description;
    }


    public Question(){}


    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
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



}
