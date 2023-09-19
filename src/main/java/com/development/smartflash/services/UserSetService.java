package com.development.smartflash.services;

import com.development.smartflash.dtos.UserSetDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserSetService {
    @Transactional
    void addSet(UserSetDto setDto, Long userId);

    @Transactional
    void deleteSetById(Long setId);

    @Transactional
    void editSetById(UserSetDto setDto);

    List<UserSetDto> getAllSetsByUserId(Long userId);

    List<UserSetDto> getAllSetsBySubject(String subject);

    List<UserSetDto> getAllSets();
}
