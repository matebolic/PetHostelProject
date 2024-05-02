package com.example.PetHostel.repository;

import com.example.PetHostel.model.PetService;
import com.example.PetHostel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetUtilityRepository extends JpaRepository<PetService, Long> {

    List<PetService> findByReservation(Reservation reservation);


}
