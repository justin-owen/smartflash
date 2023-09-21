package com.development.smartflash.services;

import com.development.smartflash.dtos.UserSetDto;
import com.development.smartflash.entities.User;
import com.development.smartflash.entities.UserSet;
import com.development.smartflash.repositories.UserRepository;
import com.development.smartflash.repositories.UserSetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserSetServiceImpl implements UserSetService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSetRepository userSetRepository;

    @Override
    @Transactional
    public void addSet(UserSetDto setDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        UserSet set = new UserSet(setDto, userOptional.get());
        userSetRepository.saveAndFlush(set);
    }

    @Override
    @Transactional
    public void deleteSetById(Long setId){
        Optional<UserSet> setOptional = userSetRepository.findById(setId);
        setOptional.ifPresent(set -> userSetRepository.delete(set));
    }

    @Override
    @Transactional
    public void editSetById(UserSetDto setDto){
        Optional<UserSet> setOptional = userSetRepository.findById(setDto.getId());
        setOptional.ifPresent(set -> {
            set.setName(setDto.getName());
            set.setSubject(setDto.getSubject());
            userSetRepository.saveAndFlush(set);
        });
    }
    @Override
    public List<UserSet> getAllSets(){
        return userSetRepository.findAll();
    }

    @Override
    public List<UserSet> getAllSetsByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<UserSet> setList = userSetRepository.findAllByUserEquals(userOptional.get());
            return setList;
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<UserSet> getAllSetsBySubject(String subject){
        return userSetRepository.findAllBySubject(subject);
    }
}
