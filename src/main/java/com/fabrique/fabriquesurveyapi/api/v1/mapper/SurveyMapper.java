package com.fabrique.fabriquesurveyapi.api.v1.mapper;

import com.fabrique.fabriquesurveyapi.api.v1.dto.SurveyDto;
import com.fabrique.fabriquesurveyapi.model.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SurveyMapper extends EntityMapper<SurveyDto, Survey>{

    SurveyMapper INSTANCE = Mappers.getMapper(SurveyMapper.class);

    Survey toEntity(SurveyDto dto);

    SurveyDto toDto(Survey entity);

    List<Survey> toEntity(List<SurveyDto> dtoList);

    List<SurveyDto> toDto(List<Survey> entityList);
}
