package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.Answer;

import java.util.Collection;
import java.util.List;

public interface AnswerService {
    List<Answer> getAllAnswers();
    Answer getAnswer();
    Collection<Answer> getAnswersForQuestion(Long questionId);
    Boolean validateAnswer(Long questionAnswerId);
}
