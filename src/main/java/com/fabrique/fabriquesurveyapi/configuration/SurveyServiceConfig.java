package com.fabrique.fabriquesurveyapi.configuration;

import com.fabrique.fabriquesurveyapi.mapper.SurveyMapper;
import com.fabrique.fabriquesurveyapi.repository.SurveyRepository;
import com.fabrique.fabriquesurveyapi.service.SurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SurveyServiceConfig {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyServiceConfig(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Bean
    SurveyServiceImpl surveyServiceImpl() {
        return new SurveyServiceImpl(SurveyMapper.INSTANCE, surveyRepository);
    }
}