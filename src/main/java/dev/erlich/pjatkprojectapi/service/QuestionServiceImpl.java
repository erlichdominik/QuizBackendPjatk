package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.Question;
import dev.erlich.pjatkprojectapi.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    private final QuestionRepository questionRepository;
    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }
}
