package dev.erlich.pjatkprojectapi;

import dev.erlich.pjatkprojectapi.model.Privilege;
import dev.erlich.pjatkprojectapi.model.Role;
import dev.erlich.pjatkprojectapi.model.User;
import dev.erlich.pjatkprojectapi.repository.PrivilegeRepository;
import dev.erlich.pjatkprojectapi.repository.RoleRepository;
import dev.erlich.pjatkprojectapi.repository.UserRepository;
import dev.erlich.pjatkprojectapi.service.UserService;
import dev.erlich.pjatkprojectapi.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Slf4j
@SpringBootApplication
@EntityScan("dev.erlich.pjatkprojectapi.model")
@RequiredArgsConstructor
public class PjatkProjectApiApplication {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    private final PrivilegeRepository privilegeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(PjatkProjectApiApplication.class, args);
    }

    //    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//            log.info("START");
//            userService.getAuthorities();
////            userRepository.save(User.builder().mail("mimikdesu@gmail.com").password("password").roles(new ArrayList<>()).build());
//            log.info("END");
//        };
//
//    }
    @Bean
    CommandLineRunner runner() {
        return args -> {
            log.info("START");

            Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
            Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

            List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
            createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
            createRoleIfNotFound("ROLE_USER", List.of(readPrivilege));

            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            User user = new User();
            user.setPassword(passwordEncoder.encode("test"));
            user.setMail("test@test.com");
            user.setRoles(List.of(adminRole));
            userRepository.save(user);
        };
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    void createRoleIfNotFound(String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
    }


}
