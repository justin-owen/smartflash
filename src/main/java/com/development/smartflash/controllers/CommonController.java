package com.development.smartflash.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CommonController {

    @GetMapping("/login")
    public String loginPage(){
        return "login.html";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register.html";
    }

    @GetMapping("/home")
    public String homePage() {return "home.html";}

    @GetMapping("/set")
    public String setPage(){return "set.html";}

    @GetMapping("/subject")
    public String subjectPage(){return "subject.html";}
}
