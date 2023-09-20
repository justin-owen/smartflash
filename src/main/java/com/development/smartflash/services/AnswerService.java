package com.development.smartflash.services;

import com.development.smartflash.dtos.AnswerDto;
import jakarta.transaction.Transactional;

public interface AnswerService {
    AnswerDto getAnswer(Long questionId);

    @Transactional
    void addAnswer(AnswerDto answerDto, Long questionId);

    @Transactional
    void editAnswer(AnswerDto answerDto);

    @Transactional
    void deleteAnswer(Long answerId);
}
