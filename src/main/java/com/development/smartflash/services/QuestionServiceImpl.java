package com.development.smartflash.services;

import com.development.smartflash.dtos.QuestionDto;
import com.development.smartflash.entities.Question;
import com.development.smartflash.entities.UserSet;
import com.development.smartflash.repositories.QuestionRepository;
import com.development.smartflash.repositories.UserSetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private UserSetRepository userSetRepository;
    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public List<QuestionDto> getAllQuestionsBySetId(Long setId){
        Optional<UserSet> setOptional = userSetRepository.findById(setId);
        if (setOptional.isPresent()){
            List<Question> questions = questionRepository.findAllBySet(setOptional.get());
            return questions.stream().map(question -> new QuestionDto(question)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addQuestion(String questionString, String answerString, Long setId){
        Optional<UserSet> userSetOptional = userSetRepository.findById(setId);
        Question question = new Question(questionString, answerString, userSetOptional.get());
        userSetOptional.ifPresent(question::setSet);
        questionRepository.saveAndFlush(question);
    }

    @Override
    @Transactional
    public void editQuestion(QuestionDto questionDto){
        Optional<Question> questionOptional = questionRepository.findById(questionDto.getId());
        questionOptional.ifPresent(question -> {
            question.setQuestion_string(questionDto.getQuestion_string());
            question.setAnswer_string(questionDto.getAnswer_string());
            questionRepository.saveAndFlush(question);
        });
    }

    @Override
    @Transactional
    public void deleteQuestion(Long questionId){
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        questionOptional.ifPresent(question -> questionRepository.delete(question));
    }

    @Override
    public Optional<QuestionDto> getQuestionById(Long questionId){
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        if (questionOptional.isPresent()){
            return Optional.of(new QuestionDto(questionOptional.get()));
        }
        return Optional.empty();
    }
}
