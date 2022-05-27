package dev.erlich.pjatkprojectapi.controller;


import dev.erlich.pjatkprojectapi.model.Answer;
import dev.erlich.pjatkprojectapi.model.Question;
import dev.erlich.pjatkprojectapi.repository.AnswerRepository;
import dev.erlich.pjatkprojectapi.repository.QuestionRepository;
import dev.erlich.pjatkprojectapi.service.AnswerService;
import dev.erlich.pjatkprojectapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @GetMapping("/a")
    public ResponseEntity<?> getAnswers() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(answerService.getAllAnswers());
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addAnswers(@RequestBody Collection<Answer> answers, @PathVariable String id) {
        Optional<Question> byId = questionService.getOptionalQuestionById(Long.valueOf(id));
        return (byId.isEmpty())
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().build();
    }

}
