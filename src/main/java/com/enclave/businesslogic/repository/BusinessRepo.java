package com.enclave.businesslogic.repository;

import com.enclave.businesslogic.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessRepo extends JpaRepository<Business, Long> {
    Optional<Business> findById(Long id);
}
