package com.fabrique.fabriquesurveyapi.controller;

import com.fabrique.fabriquesurveyapi.dto.SurveyDto;
import com.fabrique.fabriquesurveyapi.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SurveyController.BASE_URL)
public class SurveyController {

    public static final String BASE_URL = "/api/v1/survey";

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PreAuthorize("hasAuthority('read')")
    @GetMapping
    public ResponseEntity<List<SurveyDto>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }

    @PreAuthorize("hasAuthority('read')")
    @GetMapping("{id}")
    public ResponseEntity<SurveyDto> getSurveyById(@PathVariable Long id) {
        return ResponseEntity.ok(surveyService.getSurveyById(id));
    }

    @PreAuthorize("hasAuthority('write')")
    @PostMapping
    public ResponseEntity<SurveyDto> createNewSurvey(@RequestBody SurveyDto surveyDto){
        return ResponseEntity.ok(surveyService.createNewSurvey(surveyDto));
    }

    @PreAuthorize("hasAuthority('write')")
    @PutMapping("{id}")
    public ResponseEntity<SurveyDto> updateSurvey(@PathVariable Long id, @RequestBody SurveyDto surveyDto){
        return ResponseEntity.ok(surveyService.saveSurveyById(id, surveyDto));
    }

    @PreAuthorize("hasAuthority('write')")
    @PatchMapping("{id}")
    public ResponseEntity<SurveyDto> patchSurvey(@PathVariable Long id, @RequestBody SurveyDto surveyDto){
        return ResponseEntity.ok(surveyService.patchSurveyById(id, surveyDto));
    }

    @PreAuthorize("hasAuthority('write')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id){
        surveyService.deleteSurveyById(id);
        return ResponseEntity.ok().build();
    }
}
