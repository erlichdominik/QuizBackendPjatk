package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.Question;

import java.util.Optional;

public interface QuizService {
    Optional<Question> startQuiz();

    Optional<Question> getNextQuestion(Long currentQuestionID);
    Optional<Question> getQuestionById(Long questionID);
    Boolean validateQuery(Long questionAnswerID);
}
