package com.example.PetHostel.service;

import com.example.PetHostel.repository.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetOwnerService {

    @Autowired
    PetOwnerRepository petOwnerRepository;



}
