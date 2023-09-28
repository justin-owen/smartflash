package com.development.smartflash.services;

import com.development.smartflash.dtos.UserDto;
import com.development.smartflash.entities.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);

    User findById(Long userId);
}
