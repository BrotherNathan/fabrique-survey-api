package com.fabrique.fabriquesurveyapi.controller;

import com.fabrique.fabriquesurveyapi.dto.QuestionDto;
import com.fabrique.fabriquesurveyapi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(QuestionController.BASE_URL)
public class QuestionController {

    public static final String BASE_URL = "/api/v1/question";

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PreAuthorize("hasAuthority('read')")
    @GetMapping
    public ResponseEntity<List<QuestionDto>> getQuestionsBySurveyId(@RequestParam Long surveyId) {
        return ResponseEntity.ok(questionService.getQuestionsBySurveyId(surveyId));
    }

    @PreAuthorize("hasAuthority('read')")
    @GetMapping("{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @PreAuthorize("hasAuthority('write')")
    @PostMapping
    public ResponseEntity<QuestionDto> createNewQuestion(@RequestBody QuestionDto questionDto,
                                       @RequestParam(name = "surveyId") Long surveyId){
        return ResponseEntity.ok(questionService.createNewQuestion(questionDto, surveyId));
    }

    @PreAuthorize("hasAuthority('write')")
    @PatchMapping("{id}")
    public ResponseEntity<QuestionDto> patchQuestion(@PathVariable Long id, @RequestBody QuestionDto questionDto){
        return ResponseEntity.ok(questionService.patchQuestionById(id, questionDto));
    }

    @PreAuthorize("hasAuthority('write')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestionById(id);
        return ResponseEntity.ok().build();
    }
}