package com.development.smartflash.controllers;

import com.development.smartflash.dtos.QuestionDto;
import com.development.smartflash.dtos.UserSetDto;
import com.development.smartflash.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;



    @GetMapping("/set/{setId}")
    public List<QuestionDto> getQuestionsBySetId(@PathVariable Long setId){
        return questionService.getAllQuestionsBySetId(setId);
    }

    @PostMapping("/set/{setId}")
    public void addQuestion(@RequestBody QuestionDto questionDto, @PathVariable Long setId){
        questionService.addQuestion(questionDto, setId);
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
