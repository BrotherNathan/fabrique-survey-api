package com.fabrique.fabriquesurveyapi.dto;

import com.fabrique.fabriquesurveyapi.model.Question;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SurveyDto {

    private final Long id;
    private final Instant created;
    private final Instant updated;
    private final String name;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String description;
    private final List<Question> questions;
}
