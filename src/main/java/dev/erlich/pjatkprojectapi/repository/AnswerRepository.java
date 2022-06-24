package dev.erlich.pjatkprojectapi.repository;

import dev.erlich.pjatkprojectapi.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query("select a from Answer a join QuestionAnswer qa on a.id = qa.answer.id join Question q on q.id = qa.question.id where q.id = :questionId")
    Collection<Answer> getAnswersForQuestion(@Param("questionId") Long questionId);
    @Query("select qa.isCorrect from QuestionAnswer qa where qa.id = :questionAnswerId")
    Boolean validateAnswer(@Param("questionAnswerId") Long questionAnswerId);
}