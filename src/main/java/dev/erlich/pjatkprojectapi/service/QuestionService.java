package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Optional<Question> getOptionalQuestionById(Long id);

    List<Question> getAllQuestions();
}
