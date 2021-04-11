package com.enclave.businesslogic.controllers;

import com.enclave.businesslogic.domain.User;
import com.enclave.businesslogic.domain.Vehicle;
import com.enclave.businesslogic.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReceiveController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/receive")
    public String receive(@AuthenticationPrincipal User user, Vehicle vehicle, ModelMap model) {
        model.put("user", user);
        model.put("vehicle", vehicle);
        model.addAttribute("stockActive","active");
        model.addAttribute("ReceiveActive","active");
        return "receive";
    }

    @PostMapping("/receive")
    public String saveVehicle(
            @AuthenticationPrincipal User user,
            @Validated @ModelAttribute("vehicle") Vehicle vehicle,
            BindingResult bindingResult, ModelMap model) {

        boolean invalidMessage;
        boolean trueMessage;

        if (!vehicle.getArrDate().toString().isEmpty() && !vehicle.getChassisNo().isEmpty() && !vehicle.getT1No().isEmpty()){
//            System.out.println(vehicle.getArrDate());
            vehicle.setStatus("1");
            vehicle.setBusiness(user.getBusiness());
            vehicle.setUser(user);
            vehicleService.createVehicle(vehicle);
            model.put("trueMessage", true);
            model.put("vehicle", vehicle);
            model.addAttribute("stockActive","active");
            model.addAttribute("ReceiveActive","active");
        }else{
            model.put("invalidMessage", true);
        }
        return "redirect:/receive";
    }
}
