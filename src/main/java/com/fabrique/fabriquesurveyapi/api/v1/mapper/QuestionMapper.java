package com.fabrique.fabriquesurveyapi.api.v1.mapper;

import com.fabrique.fabriquesurveyapi.api.v1.dto.QuestionDto;
import com.fabrique.fabriquesurveyapi.model.Question;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface QuestionMapper extends EntityMapper<QuestionDto, Question>{

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question toEntity(QuestionDto dto);

    QuestionDto toDto(Question entity);

    List<Question> toEntity(List<QuestionDto> dtoList);

    List<QuestionDto> toDto(List<Question> entityList);
}
