package com.fabrique.fabriquesurveyapi.controller.v1;

import com.fabrique.fabriquesurveyapi.api.v1.dto.SurveyDto;
import com.fabrique.fabriquesurveyapi.service.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SurveyController.BASE_URL)
public class SurveyController {

    public static final String BASE_URL = "/api/v1/survey";

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public ResponseEntity<List<SurveyDto>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }

    @GetMapping("{id}")
    public ResponseEntity<SurveyDto> getSurveyById(@PathVariable Long id) {
        return ResponseEntity.ok(surveyService.getSurveyById(id));
    }

    @PostMapping
    public ResponseEntity<SurveyDto> createNewSurvey(@RequestBody SurveyDto surveyDto){
        return ResponseEntity.ok(surveyService.createNewSurvey(surveyDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<SurveyDto> updateSurvey(@PathVariable Long id, @RequestBody SurveyDto surveyDto){
        return ResponseEntity.ok(surveyService.saveSurveyById(id, surveyDto));
    }

    @PatchMapping("{id}")
    public ResponseEntity<SurveyDto> patchSurvey(@PathVariable Long id, @RequestBody SurveyDto surveyDto){
        return ResponseEntity.ok(surveyService.patchSurveyById(id, surveyDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id){
        surveyService.deleteSurveyById(id);
        return ResponseEntity.ok().build();
    }
}
