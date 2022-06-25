package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.Question;
import dev.erlich.pjatkprojectapi.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
   private final QuestionService questionService;
   private final AnswerService answerService;
   private final QuestionRepository questionRepository;
   private static final Long FIRST_QUESTION_ID = 1L;
    @Override
    public Optional<Question> startQuiz() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof User) username = ((User) principal).getUsername();
        if (username == null) return Optional.empty();

        // start quiz
        // get first question
        var firstQuestion = questionService.getOptionalQuestionById(FIRST_QUESTION_ID);
        if (firstQuestion.isEmpty()) return Optional.empty();

        var data = firstQuestion.get();
        return Optional.of(data);

    }

    @Override
    public Optional<Question> getNextQuestion(Long currentQuestionID) {
        return questionService.getOptionalQuestionById(currentQuestionID + 1);
    }

    @Override
    public Optional<Question> getQuestionById(Long questionID) {
        return questionRepository.findById(questionID);
    }

    @Override
    public Boolean validateQuery(Long questionAnswerID) {
       return answerService.validateAnswer(questionAnswerID);
    }
}
