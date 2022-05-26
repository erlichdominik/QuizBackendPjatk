package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.repository.RoleRepository;
import dev.erlich.pjatkprojectapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return userService.getUserByMail(mail).orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
