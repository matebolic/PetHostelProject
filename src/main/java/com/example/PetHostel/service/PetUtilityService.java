package com.example.PetHostel.service;

import com.example.PetHostel.model.PetUtility;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.repository.PetOwnerRepository;
import com.example.PetHostel.repository.PetUtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetUtilityService {


    @Autowired
    PetUtilityRepository petUtilityRepository;

    //-------------------------------------------------------------------------------//

    public PetUtility save(PetUtility petUtility) {
        return petUtilityRepository.save(petUtility);
    }

    //-------------------------------------------------------------------------------//

    public List<PetUtility> findAll() {
        return petUtilityRepository.findAll();
    }

    public List<PetUtility> findByReservation(Reservation reservation) {
        return petUtilityRepository.findByReservation(reservation);

    }

    //-------------------------------------------------------------------------------//


    //-------------------------------------------------------------------------------//
    public void deleteById(Long id) {
        petUtilityRepository.deleteById(id);
    }

    //-------------------------------------------------------------------------------//

}
