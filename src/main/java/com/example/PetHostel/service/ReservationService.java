package com.example.PetHostel.service;

import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private AnimalService animalService;


    public Reservation processReservation(
            boolean isFoodTaken,
            PetOwner petOwner,
            List<String> selectedAnimals,
            LocalDateTime arrivalTime,
            LocalDateTime deparureTime) {

        Reservation reservation = new Reservation();
        reservation.setPetOwner(petOwner).setStartingDateTime(arrivalTime).setFinishingDateTime(deparureTime).calculateDuration();

        selectedAnimals.stream().forEach(System.out::println);

        return null;
    }


    /*
    Methods should have checked  - It was all written at the beginning:
    ------------------------------------------------------------
    */

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }


}
