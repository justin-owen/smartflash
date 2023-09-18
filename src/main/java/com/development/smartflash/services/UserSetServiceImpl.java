package com.development.smartflash.services;

import com.development.smartflash.repositories.UserRepository;
import com.development.smartflash.repositories.UserSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSetServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSetRepository userSetRepository;
}
