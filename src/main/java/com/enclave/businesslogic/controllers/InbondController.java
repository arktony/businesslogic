package com.enclave.businesslogic.controllers;

import com.enclave.businesslogic.domain.Business;
import com.enclave.businesslogic.domain.User;
import com.enclave.businesslogic.domain.Vehicle;
import com.enclave.businesslogic.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InbondController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/inbond")
    public String goInBond(
            @AuthenticationPrincipal User user,
            Business business,
            ModelMap model,
            @ModelAttribute("vehicle") Vehicle vehicle,
            BindingResult bindingResult
    ){
        List<Vehicle> allVehicles;
        allVehicles =vehicleService.getAllVehiclesByBusinessId(user.getBusiness().getId());
        model.put("vehicles", allVehicles);
        model.put("user", user);
        model.addAttribute("stockActive","active");
        model.addAttribute("InbondActive","active");
        return "inbond";
    }

    @RequestMapping(path = "/vehicles/{id}", method= RequestMethod.GET)
    public Optional<Vehicle> getById(@PathVariable("id") Long id) {
        return vehicleService.getVehicleById(id);
    }

}
