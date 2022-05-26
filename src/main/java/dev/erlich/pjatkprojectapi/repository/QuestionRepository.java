package dev.erlich.pjatkprojectapi.repository;

import dev.erlich.pjatkprojectapi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}