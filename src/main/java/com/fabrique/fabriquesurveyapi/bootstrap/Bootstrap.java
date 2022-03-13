package com.fabrique.fabriquesurveyapi.bootstrap;

import com.fabrique.fabriquesurveyapi.model.*;
import com.fabrique.fabriquesurveyapi.repository.QuestionRepository;
import com.fabrique.fabriquesurveyapi.repository.SurveyRepository;
import com.fabrique.fabriquesurveyapi.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class Bootstrap {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public Bootstrap(UserRepository userRepository, PasswordEncoder passwordEncoder, SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
    }

    @SneakyThrows
    @EventListener
    @org.springframework.transaction.annotation.Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        createUsers();
        createSurveysAndQuestions();
    }

    private void createUsers() throws IOException {

        User user1 = new User();
        user1.setPassword(passwordEncoder.encode("admin"));
        user1.setUsername("admin");
        user1.setRole(Role.ADMIN);
        user1.setStatus(Status.ACTIVE);

        User user2 = new User();
        user2.setPassword(passwordEncoder.encode("user"));
        user2.setUsername("user");
        user2.setRole(Role.USER);
        user2.setStatus(Status.ACTIVE);

        userRepository.saveAll(Set.of(
                user1,
                user2
        ));
    }

    private void createSurveysAndQuestions() throws IOException {

        Question question1 = new Question(
                null,
                null,
                null,
                "Is this a first question?",
                QuestionType.ONE_OPTION
        );

        Question question2 = new Question(
                null,
                null,
                null,
                "Is this a second question?",
                QuestionType.ONE_OPTION
        );

        Question question3 = new Question(
                null,
                null,
                null,
                "Is this a third question?",
                QuestionType.ONE_OPTION
        );

        Survey survey1 = new Survey(
                null,
                null,
                null,
                "Survey #1",
                LocalDateTime.of(2022, 12, 1, 0, 0),
                LocalDateTime.of(2023, 12, 1, 0, 0),
                "Test survey # 1",
                List.of(question1)
        );

        Survey survey2 = new Survey(
                null,
                null,
                null,
                "Survey #2",
                LocalDateTime.of(2022, 12, 1, 0, 0),
                LocalDateTime.of(2023, 12, 1, 0, 0),
                "Test survey # 2",
                List.of(question2, question3)
        );

        surveyRepository.saveAll(List.of(survey1, survey2));

        System.out.println("=============================================================");
        System.out.println("Surveys loaded = " + surveyRepository.count());
        System.out.println("Questions loaded = " + questionRepository.count());
        System.out.println("=============================================================");
    }
}
