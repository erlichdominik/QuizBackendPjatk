package dev.erlich.pjatkprojectapi;

import dev.erlich.pjatkprojectapi.model.Answer;
import dev.erlich.pjatkprojectapi.model.Question;
import dev.erlich.pjatkprojectapi.model.security.Privilege;
import dev.erlich.pjatkprojectapi.model.security.Role;
import dev.erlich.pjatkprojectapi.model.security.User;
import dev.erlich.pjatkprojectapi.repository.*;
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
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

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

            Answer a1 = Answer.builder()
                    .id(1L)
                    .value("a1")
                    .build();

            Answer a2 = Answer.builder()
                    .id(2L)
                    .value("a2")
                    .build();

            Answer a3 = Answer.builder()
                    .id(3L)
                    .value("a3")
                    .build();


//            questionRepository.save(q1);
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
