package com.enclave.businesslogic.controllers;

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
            ModelMap model,
            @ModelAttribute("vehicle") Vehicle vehicle,
            BindingResult bindingResult
    ){
        List<Vehicle> allVehicles;
//        allVehicles =vehicleService.getAllVehiclesByBusinessId(user.getBusiness().getId());
        allVehicles = vehicleService.findAllVehicleByBusinessAndStatus(user.getBusiness(), "1");
        model.put("vehicles", allVehicles);
        model.put("user", user);
        model.addAttribute("stockActive","active");
        model.addAttribute("InbondActive","active");
        return "inbond";
    }

    @RequestMapping(path = "/inbond/{id}", method= RequestMethod.GET)
    public String getVehicle(@PathVariable Long id, ModelMap model, @AuthenticationPrincipal User user) {
        Optional<Vehicle> optVehicle = vehicleService.getVehicleById(id);
        if(optVehicle.isPresent()){
            Vehicle vehicle =optVehicle.get();
            model.put("vehicle", vehicle);
            model.put("user", user);
            model.addAttribute("stockActive","active");
            model.addAttribute("InbondActive","active");
            System.out.println(vehicle.getId() +" ---- "+vehicle.getYear());
        }else {
//           response.sendError(HttpStatus.NOT_FOUND.value(),"Vehicle with id" + id + "was not found");
            return "inbond";
        }
        return "vehicle";
    }

    @RequestMapping(path = "/inbond/{id}", method= RequestMethod.POST)
    public String updateVehicle(@PathVariable("id") Long id, @AuthenticationPrincipal User user, Vehicle vehicle, ModelMap model) {
        vehicle.setStatus("1");
        vehicle.setBusiness(user.getBusiness());
        vehicle.setUser(user);
        vehicleService.createVehicle(vehicle);
        model.put("trueMessage", true);
        model.put("vehicle", vehicle);
        model.addAttribute("stockActive","active");
        model.addAttribute("ReceiveActive","active");
        return "redirect:/inbond/"+vehicle.getId();
    }

}
