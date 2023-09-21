package com.development.smartflash.services;

import com.development.smartflash.dtos.UserSetDto;
import com.development.smartflash.entities.UserSet;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserSetService {
    @Transactional
    void addSet(UserSetDto setDto, Long userId);

    @Transactional
    void deleteSetById(Long setId);

    @Transactional
    void editSetById(UserSetDto setDto);

    List<UserSet> getAllSetsByUserId(Long userId);

    Optional<UserSet> getAllSetsBySubject(String subject);

    List<UserSet> getAllSets();


}
