package com.fabrique.fabriquesurveyapi.configuration;

import com.fabrique.fabriquesurveyapi.api.v1.mapper.SurveyMapper;
import com.fabrique.fabriquesurveyapi.repository.SurveyRepository;
import com.fabrique.fabriquesurveyapi.service.v1.SurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SurveyServiceConfig {

    @Autowired
    private SurveyRepository surveyRepository;

    @Bean
    SurveyServiceImpl surveyServiceImpl() {
        return new SurveyServiceImpl(SurveyMapper.INSTANCE, surveyRepository);
    }
}