package com.fabrique.fabriquesurveyapi.repository;

import com.fabrique.fabriquesurveyapi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
