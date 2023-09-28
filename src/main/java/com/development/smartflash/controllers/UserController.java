package com.development.smartflash.controllers;

import com.development.smartflash.dtos.UserDto;
import com.development.smartflash.dtos.UserSetDto;
import com.development.smartflash.entities.User;
import com.development.smartflash.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDto userDto) {
        return userService.userLogin(userDto);
    }

    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDto userDto) {
        String passHash = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(passHash);
        return userService.addUser(userDto);
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.findById(userId);
    }

}
