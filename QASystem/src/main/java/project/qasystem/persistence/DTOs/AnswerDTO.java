package project.qasystem.persistence.DTOs;

public class AnswerDTO {
    private String authorName;
    private long idQuestion;
    private long idAnswer;
    private boolean isAcceptedAnswer;
    private String text;

    public AnswerDTO(int idAnswer, int idQuestion, String authorName, boolean isAcceptedAnswer, String text){
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
        this.authorName = authorName;
        this.isAcceptedAnswer = isAcceptedAnswer;
        this.text = text;

    }

    public AnswerDTO(){}

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public long getIdAnswer() {
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
