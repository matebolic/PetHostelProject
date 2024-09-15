package com.example.PetHostel.service;

import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.model.PetServices;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.core.env.MissingRequiredPropertiesException;
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
    @Autowired
    PetUtilityService petUtilityService;


    public Reservation processReservation(
            boolean isFoodTaken,
            PetOwner petOwner,
            List<Long> selectedAnimals,
            LocalDateTime arrivalTime,
            LocalDateTime deparureTime) {

        Reservation reservation = new Reservation();
        reservation.setPetOwner(petOwner).setStartingDateTime(arrivalTime).setFinishingDateTime(deparureTime).calculateDuration();

        if (!selectedAnimals.isEmpty()) {
            selectedAnimals.stream().forEach(a -> {
                reservation.getAnimalsPerReservationsList().add(animalService.findById(a));
            });
        } else {
            throw new MissingRequiredPropertiesException();
        }

        int[] numberOfServicesFromDuration = reservation.getNumberOfServicesFromDuration();

        if (isFoodTaken) {
            reservation.getServices().add(new PetServices(petUtilityService.findByUtilityName("food"), numberOfServicesFromDuration[0]));
        }

        if (numberOfServicesFromDuration[0] > 0) {
            reservation.getServices().add(new PetServices(petUtilityService.findByUtilityName("boarding"), numberOfServicesFromDuration[0]));
        }

        if (numberOfServicesFromDuration[1] > 0) {
            reservation.getServices().add(new PetServices(petUtilityService.findByUtilityName("daycare"), numberOfServicesFromDuration[1]));
        }

        reservation.calculateTotalPriceByReservation();
        reservation.getPetOwner().pay(reservation.getPriceOfReservation()).calculateMembership();
        reservationRepository.save(reservation);

        return reservation;
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
