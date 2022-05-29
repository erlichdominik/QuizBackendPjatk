package dev.erlich.pjatkprojectapi.controller;


import dev.erlich.pjatkprojectapi.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/start")
    public String startQuiz(Model model) {
        quizService.startQuiz();
        return "home";
    }

//    @GetMapping("/a")
//    public ResponseEntity<?> getAnswers() {
//        return ResponseEntity.ok(questionService.getAllQuestions());
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<?> get() {
//        return ResponseEntity.ok(answerService.getAllAnswers());
//    }
//
//    @PostMapping("/{id}")
//    public ResponseEntity<?> addAnswers(@RequestBody Collection<Answer> answers, @PathVariable String id) {
//        Optional<Question> byId = questionService.getOptionalQuestionById(Long.valueOf(id));
//        return (byId.isEmpty())
//                ? ResponseEntity.notFound().build()
//                : ResponseEntity.ok().build();
//    }
//
}
