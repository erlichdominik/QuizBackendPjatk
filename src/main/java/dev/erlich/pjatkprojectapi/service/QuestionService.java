package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.Question;

import java.util.Optional;

public interface QuestionService {
    Optional<Question> getQuestionById(Long id);
}
