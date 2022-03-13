package com.fabrique.fabriquesurveyapi.service;

import com.fabrique.fabriquesurveyapi.dto.QuestionDto;

import java.util.List;

public interface QuestionService {

    QuestionDto getQuestionById(Long id);

    List<QuestionDto> getQuestionsBySurveyId(Long surveyId);

    QuestionDto createNewQuestion(QuestionDto questionDto, Long surveyId);

    QuestionDto patchQuestionById(Long id, QuestionDto questionDto);

    void deleteQuestionById(Long id);
}
