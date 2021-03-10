package com.enclave.businesslogic.controllers;

import com.enclave.businesslogic.domain.Business;
import com.enclave.businesslogic.domain.User;
import com.enclave.businesslogic.service.BusinessService;
import com.enclave.businesslogic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusinessController {
    @Autowired
    private UserService userService;

    @Autowired
    private BusinessService businessService;

    @GetMapping("/auth-signup")
    public String getBusiness(ModelMap model){
        Business business = new Business();
        model.put("business", business);
        return "auth-signup";
    }

    @PostMapping("/auth-signup")
    public String createBusiness(@Validated @ModelAttribute("business") Business business, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "auth-signup";
        }
            //Creating a new user object to save new user on business account creation
            User user = new User();
            business = businessService.createBusiness(business);
            user.setUsername(business.getEmail());
            user.setPassword("12345");
            user.setBusiness(business);
            userService.save(user);
            return "index";

    }
}
