package com.fabrique.fabriquesurveyapi.configuration;

import com.fabrique.fabriquesurveyapi.api.v1.mapper.QuestionMapper;
import com.fabrique.fabriquesurveyapi.repository.QuestionRepository;
import com.fabrique.fabriquesurveyapi.repository.SurveyRepository;
import com.fabrique.fabriquesurveyapi.service.v1.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionServiceConfig {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SurveyRepository surveyRepository;

    @Bean
    QuestionServiceImpl questionServiceImpl() {
        return new QuestionServiceImpl(QuestionMapper.INSTANCE, questionRepository, surveyRepository);
    }
}