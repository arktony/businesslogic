package com.enclave.businesslogic.controllers;

import com.enclave.businesslogic.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal User user, ModelMap model){
        model.put("user", user);
        System.out.println(user.getFirstName() +" "+user.getLastName());
        return "dashboard";
    }

    @PostMapping("/login")
    public String login() {
        return "dashboard";
    }

}
