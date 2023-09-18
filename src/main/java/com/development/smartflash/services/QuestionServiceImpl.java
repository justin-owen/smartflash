package com.development.smartflash.services;

import com.development.smartflash.repositories.QuestionRepository;
import com.development.smartflash.repositories.UserSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl {
    @Autowired
    private UserSetRepository userSetRepository;
    @Autowired
    private QuestionRepository questionRepository;
}
