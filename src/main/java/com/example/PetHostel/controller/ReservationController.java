package com.example.PetHostel.controller;


import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cathostel/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @GetMapping("/findAll")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Reservation findById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        reservationService.deleteById(id);
    }

}
