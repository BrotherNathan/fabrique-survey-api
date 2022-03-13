package com.fabrique.fabriquesurveyapi.mapper;

import com.fabrique.fabriquesurveyapi.dto.QuestionDto;
import com.fabrique.fabriquesurveyapi.model.Question;
import com.fabrique.fabriquesurveyapi.model.QuestionType;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-13T10:32:18+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (N/A)"
)
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question toEntity(QuestionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( dto.getId() );
        question.setCreated( dto.getCreated() );
        question.setUpdated( dto.getUpdated() );
        question.setText( dto.getText() );
        question.setQuestionType( dto.getQuestionType() );

        return question;
    }

    @Override
    public QuestionDto toDto(Question entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Instant created = null;
        Instant updated = null;
        String text = null;
        QuestionType questionType = null;

        id = entity.getId();
        created = entity.getCreated();
        updated = entity.getUpdated();
        text = entity.getText();
        questionType = entity.getQuestionType();

        QuestionDto questionDto = new QuestionDto( id, created, updated, text, questionType );

        return questionDto;
    }

    @Override
    public List<Question> toEntity(List<QuestionDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Question> list = new ArrayList<Question>( dtoList.size() );
        for ( QuestionDto questionDto : dtoList ) {
            list.add( toEntity( questionDto ) );
        }

        return list;
    }

    @Override
    public List<QuestionDto> toDto(List<Question> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<QuestionDto> list = new ArrayList<QuestionDto>( entityList.size() );
        for ( Question question : entityList ) {
            list.add( toDto( question ) );
        }

        return list;
    }
}
