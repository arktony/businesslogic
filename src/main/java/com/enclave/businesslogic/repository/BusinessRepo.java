package com.enclave.businesslogic.repository;

import com.enclave.businesslogic.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepo extends JpaRepository<Business, Long> {
}
