package com.fabrique.fabriquesurveyapi.service;

import com.fabrique.fabriquesurveyapi.dto.QuestionDto;
import com.fabrique.fabriquesurveyapi.mapper.QuestionMapper;
import com.fabrique.fabriquesurveyapi.model.Survey;
import com.fabrique.fabriquesurveyapi.repository.QuestionRepository;
import com.fabrique.fabriquesurveyapi.repository.SurveyRepository;
import com.fabrique.fabriquesurveyapi.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;

    @Override
    public QuestionDto getQuestionById(Long id) {
        return questionRepository.findById(id)
                .map(questionMapper::toDto)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<QuestionDto> getQuestionsBySurveyId(Long surveyId) {
        return surveyRepository.findById(surveyId)
                .orElseThrow(ResourceNotFoundException::new)
                .getQuestions()
                .stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDto createNewQuestion(QuestionDto questionDto, Long surveyId) {
            Survey surveyWithNewQuestion = surveyRepository.findById(surveyId)
                    .orElseThrow(ResourceNotFoundException::new);
            surveyWithNewQuestion.addQuestion(questionMapper.toEntity(questionDto));
            Survey savedSurveyWithNewQuestion = surveyRepository.save(surveyWithNewQuestion);
            return questionMapper.toDto(
                    savedSurveyWithNewQuestion
                            .getQuestions()
                            .get(savedSurveyWithNewQuestion.getQuestions().size()-1));
    }

    @Override
    public QuestionDto patchQuestionById(Long id, QuestionDto questionDto) {
        return questionRepository.findById(id).map(question -> {
            if(questionDto.getText() != null){
                question.setText(questionDto.getText());
            }
            else if(questionDto.getQuestionType() != null){
                question.setQuestionType(questionDto.getQuestionType());
            }
            return questionMapper.toDto(questionRepository.save(question));
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
    }
}