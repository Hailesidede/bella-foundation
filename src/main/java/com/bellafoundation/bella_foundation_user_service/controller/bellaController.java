package com.bellafoundation.bella_foundation_user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bella/")
public class bellaController {

    @GetMapping("welcome")
    public String welcomeController(){
        return "Welcome to Bella Foundation Service";
    }
}
