package dev.erlich.pjatkprojectapi.repository;

import dev.erlich.pjatkprojectapi.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMail(String mail);
}
