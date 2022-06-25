package dev.erlich.pjatkprojectapi.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {
    Optional<UserDetails> getUserByMail(String mail);

}
