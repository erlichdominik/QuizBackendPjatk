package dev.erlich.pjatkprojectapi.service;

import dev.erlich.pjatkprojectapi.model.security.Privilege;
import dev.erlich.pjatkprojectapi.model.security.Role;
import dev.erlich.pjatkprojectapi.repository.RoleRepository;
import dev.erlich.pjatkprojectapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    // What do you think about putting each *serviceImpl into -> impl package? @Dom

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public Optional<UserDetails> getUserByMail(String mail) {
        var byMail = userRepository.findByMail(mail);
        if (byMail == null) return Optional.empty();
        User user = new User(byMail.getMail(), byMail.getPassword(), getAuthorities(byMail.getRoles()));
        return Optional.of(user);
    }

    public Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
