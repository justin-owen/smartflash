package com.development.smartflash.services;

import com.development.smartflash.dtos.AnswerDto;
import com.development.smartflash.dtos.QuestionDto;
import com.development.smartflash.entities.Answer;
import com.development.smartflash.entities.Question;
import com.development.smartflash.entities.UserSet;
import com.development.smartflash.repositories.AnswerRepository;
import com.development.smartflash.repositories.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public AnswerDto getAnswer(Long questionId){
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        if (questionOptional.isPresent()){
            Answer answer = answerRepository.findByQuestionId(questionOptional.get());
            return new AnswerDto(answer);
        }
        return null;
    }

    @Override
    @Transactional
    public void addAnswer(AnswerDto answerDto, Long questionId){
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        Answer answer = new Answer(answerDto);
        questionOptional.ifPresent(answer::setQuestion);
        answerRepository.saveAndFlush(answer);
    }

    @Override
    @Transactional
    public void editAnswer(AnswerDto answerDto){
        Optional<Answer> answerOptional = answerRepository.findById(answerDto.getId());
        answerOptional.ifPresent(answer -> {
            answer.setAnswer_string(answerDto.getAnswer_string());
            answerRepository.saveAndFlush(answer);
        });
    }


    @Override
    @Transactional
    public void deleteAnswer(Long answerId){
        Optional<Answer> answerOptional = answerRepository.findById(answerId);
        answerOptional.ifPresent(answer -> answerRepository.delete(answer));
    }
}
