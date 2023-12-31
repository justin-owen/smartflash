package com.development.smartflash.services;

import com.development.smartflash.dtos.QuestionDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<QuestionDto> getAllQuestionsBySetId(Long setId);

    @Transactional
    void addQuestion(String questionString, String answerString, Long setId);

    @Transactional
    void editQuestion(QuestionDto questionDto);

    @Transactional
    void deleteQuestion(Long questionId);

    Optional<QuestionDto> getQuestionById(Long questionId);
}
