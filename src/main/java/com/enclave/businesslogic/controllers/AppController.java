package com.enclave.businesslogic.controllers;

import com.enclave.businesslogic.domain.User;
import com.enclave.businesslogic.service.UserDetailsServiceImpl;
import com.enclave.businesslogic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @PostMapping("/login")
    public String login() {
        return "dashboard";
    }
}
