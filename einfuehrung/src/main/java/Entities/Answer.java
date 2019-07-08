package Entities;

public class Answer {
    private String authorName;
    private int idQuestion;
    private int idAnswer;
    private boolean isAcceptedAnswer;
    private String text;

    public Answer(int idAnswer, int idQuestion, String authorName, boolean isAcceptedAnswer, String text){
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
        this.authorName = authorName;
        this.isAcceptedAnswer = isAcceptedAnswer;
        this.text = text;
    }

    public Answer(){}

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public boolean isAcceptedAnswer() {
        return isAcceptedAnswer;
    }

    public void setAcceptedAnswer(boolean acceptedAnswer) {
        isAcceptedAnswer = acceptedAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
