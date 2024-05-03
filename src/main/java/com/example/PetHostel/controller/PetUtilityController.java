package com.example.PetHostel.controller;

import com.example.PetHostel.model.PetServices;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.service.PetServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cathostel/utilities")
public class PetUtilityController {

    @Autowired
    PetServicesService petServicesService;

    //-------------------------------------------------------------------------------//

    @PostMapping("/save")
    public PetServices save(@RequestBody PetServices petServices) {
        return petServicesService.save(petServices);
    }

    //-------------------------------------------------------------------------------//

    @GetMapping("/findByReservation")
    public List<PetServices> findByReservation(@RequestBody Reservation reservation) {
        return petServicesService.findByReservation(reservation);
    }


    @GetMapping("/findAll")
    public List<PetServices> findAll() {
        return petServicesService.findAll();
    }


    //-------------------------------------------------------------------------------//

    @PostMapping("/update")
    public PetServices update(@RequestBody PetServices petServices) {
        return petServicesService.save(petServices);
    }


    //-------------------------------------------------------------------------------//

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        petServicesService.deleteById(id);
    }

    //-------------------------------------------------------------------------------//


}
