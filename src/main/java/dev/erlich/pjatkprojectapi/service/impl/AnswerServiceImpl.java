package dev.erlich.pjatkprojectapi.service.impl;

import dev.erlich.pjatkprojectapi.model.Answer;
import dev.erlich.pjatkprojectapi.repository.AnswerRepository;
import dev.erlich.pjatkprojectapi.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
}
