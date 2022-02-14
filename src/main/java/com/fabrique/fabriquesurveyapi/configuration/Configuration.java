package com.fabrique.fabriquesurveyapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    @ConfigurationProperties(prefix = "api")
    public ApiConfiguration apiConfiguration() {
        return new ApiConfiguration();
    }

    public class ApiConfiguration {
        private String baseUrl;
    }
}



