package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.Answer;
import dev.erlich.pjatkprojectapi.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswer() {
        return null;
    }

    @Override
    public Collection<Answer> getAnswersForQuestion(Long questionId) {
        return answerRepository.getAnswersForQuestion(questionId);
    }

    @Override
    public Boolean validateAnswer(Long questionAnswerId) {
        return answerRepository.validateAnswer(questionAnswerId);
    }
}
