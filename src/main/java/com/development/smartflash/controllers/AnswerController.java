package com.development.smartflash.controllers;

import com.development.smartflash.dtos.AnswerDto;
import com.development.smartflash.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("/question/{questionId}")
    public AnswerDto getAnswer(@PathVariable Long questionId){
        return answerService.getAnswer(questionId);
    }

    @PostMapping("/question/{questionId}")
    public void addQuestion(@RequestBody AnswerDto answerDto, @PathVariable Long questionId){
        answerService.addAnswer(answerDto, questionId);
    }

    @DeleteMapping("/{answerId}")
    public void deleteAnswer(@PathVariable Long answerId){
        answerService.deleteAnswer(answerId);
    }

    @PutMapping("/")
    public void editAnswer(@RequestBody AnswerDto answerDto){
        answerService.editAnswer(answerDto);
    }
}
