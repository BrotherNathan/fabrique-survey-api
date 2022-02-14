package com.fabrique.fabriquesurveyapi.service;

import com.fabrique.fabriquesurveyapi.api.v1.dto.SurveyDto;

import java.util.List;

public interface SurveyService {

    SurveyDto getSurveyById(Long id);

    List<SurveyDto> getAllSurveys();

    SurveyDto createNewSurvey(SurveyDto surveyDto);

    SurveyDto saveSurveyById(Long id, SurveyDto surveyDto);

    SurveyDto patchSurveyById(Long id, SurveyDto surveyDto);

    void deleteSurveyById(Long id);
}
