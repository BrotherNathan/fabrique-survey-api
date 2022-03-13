package com.fabrique.fabriquesurveyapi.mapper;

import com.fabrique.fabriquesurveyapi.dto.SurveyDto;
import com.fabrique.fabriquesurveyapi.model.Question;
import com.fabrique.fabriquesurveyapi.model.Survey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-13T10:32:18+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (N/A)"
)
public class SurveyMapperImpl implements SurveyMapper {

    @Override
    public Survey toEntity(SurveyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Survey survey = new Survey();

        survey.setStartDate( dto.getStartDate() );
        survey.setId( dto.getId() );
        survey.setCreated( dto.getCreated() );
        survey.setUpdated( dto.getUpdated() );
        survey.setName( dto.getName() );
        survey.setEndDate( dto.getEndDate() );
        survey.setDescription( dto.getDescription() );
        List<Question> list = dto.getQuestions();
        if ( list != null ) {
            survey.setQuestions( new ArrayList<Question>( list ) );
        }

        return survey;
    }

    @Override
    public SurveyDto toDto(Survey entity) {
        if ( entity == null ) {
            return null;
        }

        List<Question> questions = null;
        Long id = null;
        Instant created = null;
        Instant updated = null;
        String name = null;
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        String description = null;

        List<Question> list = entity.getQuestions();
        if ( list != null ) {
            questions = new ArrayList<Question>( list );
        }
        id = entity.getId();
        created = entity.getCreated();
        updated = entity.getUpdated();
        name = entity.getName();
        startDate = entity.getStartDate();
        endDate = entity.getEndDate();
        description = entity.getDescription();

        SurveyDto surveyDto = new SurveyDto( id, created, updated, name, startDate, endDate, description, questions );

        return surveyDto;
    }

    @Override
    public List<Survey> toEntity(List<SurveyDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Survey> list = new ArrayList<Survey>( dtoList.size() );
        for ( SurveyDto surveyDto : dtoList ) {
            list.add( toEntity( surveyDto ) );
        }

        return list;
    }

    @Override
    public List<SurveyDto> toDto(List<Survey> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SurveyDto> list = new ArrayList<SurveyDto>( entityList.size() );
        for ( Survey survey : entityList ) {
            list.add( toDto( survey ) );
        }

        return list;
    }
}
