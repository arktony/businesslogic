package com.enclave.businesslogic.service;

import com.enclave.businesslogic.domain.Business;
import com.enclave.businesslogic.domain.Vehicle;
import com.enclave.businesslogic.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;

    public void createVehicle(Vehicle vehicle){
        vehicle = vehicleRepo.save(vehicle);
    }

    public List<Vehicle> getAllVehiclesByBusinessId(Long id) {
        return vehicleRepo.getVehiclesByBusinessId(id);
    }

    public List<Vehicle> findAllVehicleByBusinessAndStatus(Business business, String status){
        return vehicleRepo.findByBusinessAndStatus(business, status);
    }

    public Optional<Vehicle> getVehicleById(Long id){
        return vehicleRepo.findById(id);
    }



}
