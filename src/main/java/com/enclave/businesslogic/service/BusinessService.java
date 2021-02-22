package com.enclave.businesslogic.service;

import com.enclave.businesslogic.domain.Business;
import com.enclave.businesslogic.repository.BusinessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    @Autowired
    private BusinessRepo businessRepo;

    public Business createBusiness(Business business){
        business.setStatus("1");
        business = businessRepo.save(business);
        return business;
    }
}
