package com.development.smartflash.controllers;

import com.development.smartflash.dtos.UserSetDto;
import com.development.smartflash.services.UserSetService;
import com.development.smartflash.services.UserSetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sets")
public class UserSetController {
    @Autowired
    private UserSetService userSetService;

    @GetMapping("/")
    public List<UserSetDto> getAllSets(){
        return userSetService.getAllSets();
    }

    @GetMapping("/user/{userId}")
    public List<UserSetDto> getSetsByUser(@PathVariable Long userId){
        return userSetService.getAllSetsByUserId(userId);
    }

    @GetMapping("/subject/{subject}")
    public List<UserSetDto> getSetsBySubject(@PathVariable String subject){
        return userSetService.getAllSetsBySubject(subject);
    }

    @PostMapping("/user/{userId}")
    public void addSet(@RequestBody UserSetDto setDto, @PathVariable Long userId){
        userSetService.addSet(setDto, userId);
    }

    @DeleteMapping("/{setId}")
    public void deleteSet(@PathVariable Long setId){
        userSetService.deleteSetById(setId);
    }

    @PutMapping("/")
    public void editSet(@RequestBody UserSetDto setDto){
        userSetService.editSetById(setDto);
    }
}
