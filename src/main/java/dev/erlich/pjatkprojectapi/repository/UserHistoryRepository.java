package dev.erlich.pjatkprojectapi.repository;

import dev.erlich.pjatkprojectapi.model.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}