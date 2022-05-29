package dev.erlich.pjatkprojectapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
   private final QuestionService questionService;
   private final AnswerService answerService;
    @Override
    public void startQuiz() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof User) username = ((User) principal).getUsername();
        if (username == null) return;


    }
}
