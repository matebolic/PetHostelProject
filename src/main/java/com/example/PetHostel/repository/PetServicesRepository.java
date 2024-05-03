package com.example.PetHostel.repository;

import com.example.PetHostel.model.PetServices;
import com.example.PetHostel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetServicesRepository extends JpaRepository<PetServices, Long> {

    List<PetServices> findByReservation(Reservation reservation);


}
