package com.example.PetHostel.repository;

import com.example.PetHostel.model.PetUtility;
import com.example.PetHostel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetUtilityRepository extends JpaRepository<PetUtility, Long> {

    List<PetUtility> findByReservation(Reservation reservation);


}
