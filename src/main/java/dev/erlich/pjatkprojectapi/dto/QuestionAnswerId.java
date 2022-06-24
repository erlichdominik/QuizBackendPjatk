package dev.erlich.pjatkprojectapi.dto;

import lombok.Data;

@Data
public class QuestionAnswerId {
    private Long id;
    private Long currentQuestionId;

    public QuestionAnswerId(Long currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }
}
