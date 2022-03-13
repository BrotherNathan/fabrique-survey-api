package com.fabrique.fabriquesurveyapi.configuration;

import com.fabrique.fabriquesurveyapi.mapper.QuestionMapper;
import com.fabrique.fabriquesurveyapi.repository.QuestionRepository;
import com.fabrique.fabriquesurveyapi.repository.SurveyRepository;
import com.fabrique.fabriquesurveyapi.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionServiceConfig {

    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;

    @Autowired
    public QuestionServiceConfig(QuestionRepository questionRepository, SurveyRepository surveyRepository) {
        this.questionRepository = questionRepository;
        this.surveyRepository = surveyRepository;
    }

    @Bean
    QuestionServiceImpl questionServiceImpl() {
        return new QuestionServiceImpl(QuestionMapper.INSTANCE, questionRepository, surveyRepository);
    }
}