package com.enclave.businesslogic.repository;

import com.enclave.businesslogic.domain.Business;
import com.enclave.businesslogic.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    String status ="1";

    @Query(value = "SELECT * FROM vehicle WHERE business_id = :businessId AND status ='1'", nativeQuery = true)
    List<Vehicle> getVehiclesByBusinessId(Long businessId);

    List<Vehicle> findByBusinessAndStatus(Business business, String status);
}