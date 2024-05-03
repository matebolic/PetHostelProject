package com.example.PetHostel.service;

import com.example.PetHostel.model.PetServices;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.repository.PetServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServicesService {


    @Autowired
    PetServicesRepository petServicesRepository;

    //-------------------------------------------------------------------------------//

    public PetServices save(PetServices petServices) {
        return petServicesRepository.save(petServices);
    }

    //-------------------------------------------------------------------------------//

    public List<PetServices> findAll() {
        return petServicesRepository.findAll();
    }

    public List<PetServices> findByReservation(Reservation reservation) {
        return petServicesRepository.findByReservation(reservation);

    }

    //-------------------------------------------------------------------------------//


    //-------------------------------------------------------------------------------//
    public void deleteById(Long id) {
        petServicesRepository.deleteById(id);
    }

    //-------------------------------------------------------------------------------//

}
