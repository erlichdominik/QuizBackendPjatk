package dev.erlich.pjatkprojectapi.controller;


import dev.erlich.pjatkprojectapi.dto.QuestionAnswerId;
import dev.erlich.pjatkprojectapi.model.Question;
import dev.erlich.pjatkprojectapi.model.UserHistory;
import dev.erlich.pjatkprojectapi.repository.UserHistoryRepository;
import dev.erlich.pjatkprojectapi.repository.UserRepository;
import dev.erlich.pjatkprojectapi.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.Mode;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@Slf4j
public class QuizController {
    private final QuizService quizService;
    private final UserHistoryRepository userHistoryRepository;
    private final UserRepository userRepository;

    @GetMapping("/")
    public String main(Model model) {
        return "home";
    }

    @GetMapping("/start")
    public String startQuizAction(Model model, @CurrentSecurityContext SecurityContext context) {
        log.info(context.getAuthentication().getName());
        return "redirect:/question/1";
    }

    @GetMapping("/question/{id}")
    public String getQuestionById(Model model, @PathVariable Long id) {
        Question question = quizService.getQuestionById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model.addAttribute("question", question);
        model.addAttribute("questionAnswerId", new QuestionAnswerId(question.getId()));

        return "question";
    }

    @GetMapping("/finish")
    public String finishQuiz(Model model) {
        return "finish";
    }

    @GetMapping("/wrong")
    public String wrongAnswer(Model model) {
        return "wrong";
    }

    @PostMapping("/next-question")
    public String nextQuestionAction(@ModelAttribute(value = "questionAnswerId") QuestionAnswerId questionAnswerId, Model model, HttpServletRequest request) {
        Long id = questionAnswerId.getId();
        if (quizService.getNextQuestion(questionAnswerId.getCurrentQuestionId()).isEmpty() && quizService.validateQuery(id)) {
            return "redirect:finish/";
        }
        if (quizService.validateQuery(id)) {
            long l = questionAnswerId.getCurrentQuestionId() + 1;
            return "redirect:question/" + l;
        }

        return "redirect:wrong/";
    }

}
