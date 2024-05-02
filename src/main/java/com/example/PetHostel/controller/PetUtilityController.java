package com.example.PetHostel.controller;

import com.example.PetHostel.model.PetService;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.service.PetUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cathostel/utilities")
public class PetUtilityController {

    @Autowired
    PetUtilityService petUtilityService;

    //-------------------------------------------------------------------------------//

    @PostMapping("/save")
    public PetService save(@RequestBody PetService petService) {
        return petUtilityService.save(petService);
    }

    //-------------------------------------------------------------------------------//

    @GetMapping("/findByReservation")
    public List<PetService> findByReservation(@RequestBody Reservation reservation) {
        return petUtilityService.findByReservation(reservation);
    }


    @GetMapping("/findAll")
    public List<PetService> findAll() {
        return petUtilityService.findAll();
    }


    //-------------------------------------------------------------------------------//

    @PostMapping("/update")
    public PetService update(@RequestBody PetService petService) {
        return petUtilityService.save(petService);
    }


    //-------------------------------------------------------------------------------//

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        petUtilityService.deleteById(id);
    }

    //-------------------------------------------------------------------------------//


}
