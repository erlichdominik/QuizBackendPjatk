package dev.erlich.pjatkprojectapi.service.impl;

import dev.erlich.pjatkprojectapi.model.Question;
import dev.erlich.pjatkprojectapi.repository.QuestionRepository;
import dev.erlich.pjatkprojectapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Optional<Question> getOptionalQuestionById(Long id) {
        return Optional.of(questionRepository.getById(id));
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
