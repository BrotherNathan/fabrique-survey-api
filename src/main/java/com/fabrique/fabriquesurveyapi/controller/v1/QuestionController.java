package com.fabrique.fabriquesurveyapi.controller.v1;

import com.fabrique.fabriquesurveyapi.api.v1.dto.QuestionDto;
import com.fabrique.fabriquesurveyapi.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(QuestionController.BASE_URL)
public class QuestionController {

    public static final String BASE_URL = "/api/v1/question";

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getQuestionsBySurveyId(@RequestParam Long postId) {
        return ResponseEntity.ok(questionService.getQuestionsBySurveyId(postId));
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @PostMapping
    public ResponseEntity<QuestionDto> createNewQuestion(@RequestBody QuestionDto questionDto,
                                       @RequestParam(name = "postId") Long postId){
        return ResponseEntity.ok(questionService.createNewQuestion(questionDto, postId));
    }

    @PatchMapping("{id}")
    public ResponseEntity<QuestionDto> patchQuestion(@PathVariable Long id, @RequestBody QuestionDto questionDto){
        return ResponseEntity.ok(questionService.patchQuestionById(id, questionDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestionById(id);
        return ResponseEntity.ok().build();
    }
}