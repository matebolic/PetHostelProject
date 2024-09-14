package com.example.PetHostel.service;

import com.example.PetHostel.model.PetUtility;
import com.example.PetHostel.repository.PetUtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetUtilityService {

    @Autowired
    PetUtilityRepository petUtilityRepository;

    public PetUtility findByUtilityName(String utilityName) {
        return petUtilityRepository.findByUtilityName(utilityName);
    }

}
