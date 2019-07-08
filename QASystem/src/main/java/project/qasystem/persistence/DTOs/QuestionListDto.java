package project.qasystem.persistence.DTOs;

import java.util.List;

public class QuestionListDto {
    private List<QuestionDto> questionDtoList;

    public QuestionListDto(List<QuestionDto> questionDtoList) {
        this.questionDtoList = questionDtoList;
    }
}
