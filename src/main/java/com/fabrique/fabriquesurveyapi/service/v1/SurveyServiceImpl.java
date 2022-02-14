package com.fabrique.fabriquesurveyapi.service.v1;

import com.fabrique.fabriquesurveyapi.api.v1.dto.SurveyDto;
import com.fabrique.fabriquesurveyapi.api.v1.mapper.SurveyMapper;
import com.fabrique.fabriquesurveyapi.model.Survey;
import com.fabrique.fabriquesurveyapi.model.exception.IllegalOperationException;
import com.fabrique.fabriquesurveyapi.repository.SurveyRepository;
import com.fabrique.fabriquesurveyapi.service.SurveyService;
import com.fabrique.fabriquesurveyapi.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyMapper surveyMapper;
    private final SurveyRepository surveyRepository;

    @Override
    public SurveyDto getSurveyById(Long id) {
        return surveyRepository.findById(id)
                .map(surveyMapper::toDto)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<SurveyDto> getAllSurveys() {
        return surveyMapper.toDto(surveyRepository.findAll());
    }

    private SurveyDto saveAndReturnDto(Survey survey) {
        Survey savedSurvey = surveyRepository.save(survey);
        return surveyMapper.toDto(savedSurvey);
    }

    @Override
    public SurveyDto createNewSurvey(SurveyDto surveyDto) {
        return saveAndReturnDto(surveyMapper.toEntity(surveyDto));
    }

    @Override
    public SurveyDto saveSurveyById(Long id, SurveyDto surveyDto) {
        Survey survey = surveyMapper.toEntity(surveyDto);
        survey.setId(id);
        return saveAndReturnDto(survey);
    }

    @Override
    public SurveyDto patchSurveyById(Long id, SurveyDto surveyDto) {
        return surveyRepository.findById(id).map(survey -> {
            if(surveyDto.getName() != null){
                survey.setName(surveyDto.getName());
            }
            else if(surveyDto.getStartDate() != null){
                throw new IllegalOperationException("You cannot change start date after is was set.");
            }
            else if(surveyDto.getEndDate() != null){
                survey.setEndDate(surveyDto.getEndDate());
            }
            else if(surveyDto.getDescription() != null){
                survey.setDescription(surveyDto.getDescription());
            }
            return surveyMapper.toDto(surveyRepository.save(survey));
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteSurveyById(Long id) {
        surveyRepository.deleteById(id);
    }
}
