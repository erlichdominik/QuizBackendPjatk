package dev.erlich.pjatkprojectapi.repository;

import dev.erlich.pjatkprojectapi.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}