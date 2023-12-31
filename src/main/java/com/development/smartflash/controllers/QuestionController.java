package com.development.smartflash.controllers;

import com.development.smartflash.dtos.QuestionDto;
import com.development.smartflash.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    private QuestionDto question;

    @GetMapping("/set/{setId}")
    public List<QuestionDto> getQuestionsBySetId(@PathVariable Long setId){
        return questionService.getAllQuestionsBySetId(setId);
    }

    @GetMapping("/{questionId}")
    public Optional<QuestionDto> getQuestionById(@PathVariable Long questionId){
        return questionService.getQuestionById(questionId);
    }

    @PostMapping("/set/{setId}")
    public void addQuestion(@RequestBody Map<String, String> json , @PathVariable Long setId){
        String questionString = json.get("question_string");
        String answerString = json.get("answer_string");
        questionService.addQuestion(questionString, answerString, setId);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable Long questionId){
        questionService.deleteQuestion(questionId);
    }

    @PutMapping("/")
    public void editQuestion(@RequestBody QuestionDto questionDto){
        questionService.editQuestion(questionDto);
    }
}
