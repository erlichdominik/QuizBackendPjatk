package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.Question;
import dev.erlich.pjatkprojectapi.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public Optional<Question> getOptionalQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

}
