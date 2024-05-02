package com.example.PetHostel.service;

import com.example.PetHostel.model.PetService;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.repository.PetUtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetUtilityService {


    @Autowired
    PetUtilityRepository petUtilityRepository;

    //-------------------------------------------------------------------------------//

    public PetService save(PetService petService) {
        return petUtilityRepository.save(petService);
    }

    //-------------------------------------------------------------------------------//

    public List<PetService> findAll() {
        return petUtilityRepository.findAll();
    }

    public List<PetService> findByReservation(Reservation reservation) {
        return petUtilityRepository.findByReservation(reservation);

    }

    //-------------------------------------------------------------------------------//


    //-------------------------------------------------------------------------------//
    public void deleteById(Long id) {
        petUtilityRepository.deleteById(id);
    }

    //-------------------------------------------------------------------------------//

}
