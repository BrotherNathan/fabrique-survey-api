package com.fabrique.fabriquesurveyapi.dto;

import com.fabrique.fabriquesurveyapi.model.QuestionType;
import lombok.Data;

import java.time.Instant;

@Data
public class QuestionDto {

    private final Long id;
    private final Instant created;
    private final Instant updated;
    private final String text;
    private final QuestionType questionType;
}
