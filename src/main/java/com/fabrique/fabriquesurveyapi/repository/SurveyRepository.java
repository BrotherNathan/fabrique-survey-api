package com.fabrique.fabriquesurveyapi.repository;

import com.fabrique.fabriquesurveyapi.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
