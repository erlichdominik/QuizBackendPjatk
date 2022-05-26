package dev.erlich.pjatkprojectapi.controller;


import dev.erlich.pjatkprojectapi.model.Answer;
import dev.erlich.pjatkprojectapi.model.Question;
import dev.erlich.pjatkprojectapi.repository.AnswerRepository;
import dev.erlich.pjatkprojectapi.repository.QuestionRepository;
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
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @GetMapping("/a")
    public ResponseEntity<?> getAnswers() {
        return ResponseEntity.ok(questionRepository.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<?> get() {
        List<Answer> all = answerRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addAnswers(@RequestBody Collection<Answer> answers, @PathVariable String id) {
        Optional<Question> byId = questionRepository.findById(Long.valueOf(id));
        if (byId.isEmpty()) return ResponseEntity.notFound().build();
        byId.get().setAnswers((List<Answer>) answers);
        return ResponseEntity.ok().build();

    }

}
