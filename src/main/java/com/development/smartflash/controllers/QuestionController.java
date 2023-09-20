package com.development.smartflash.controllers;

import com.development.smartflash.dtos.AnswerDto;
import com.development.smartflash.dtos.QuestionDto;
import com.development.smartflash.dtos.UserSetDto;
import com.development.smartflash.services.AnswerService;
import com.development.smartflash.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;



    @GetMapping("/set/{setId}")
    public List<QuestionDto> getQuestionsBySetId(@PathVariable Long setId){
        return questionService.getAllQuestionsBySetId(setId);
    }

    @PostMapping("/set/{setId}")
    public void addQuestion(@RequestBody Map<String, String> json , @PathVariable Long setId){
        String questionString = json.get("question_string");
        String answerString = json.get("answer_string");
        Long questionId = questionService.addQuestion(questionString, setId);
//        answerService.addAnswer(answerDto, questionId);
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
