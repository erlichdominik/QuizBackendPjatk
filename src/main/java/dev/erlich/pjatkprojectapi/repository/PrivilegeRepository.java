package dev.erlich.pjatkprojectapi.repository;

import dev.erlich.pjatkprojectapi.model.security.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String name);
}
