package com.example.PetHostel.controller;

import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.model.PetUtility;
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
    public PetUtility save(@RequestBody PetUtility petUtility) {
        return petUtilityService.save(petUtility);
    }

    //-------------------------------------------------------------------------------//

    @GetMapping("/findByReservation")
    public List<PetUtility> findByReservation(@RequestBody Reservation reservation) {
        return petUtilityService.findByReservation(reservation);
    }


    @GetMapping("/findAll")
    public List<PetUtility> findAll() {
        return petUtilityService.findAll();
    }


    //-------------------------------------------------------------------------------//

    @PostMapping("/update")
    public PetUtility update(@RequestBody PetUtility petUtility) {
        return petUtilityService.save(petUtility);
    }


    //-------------------------------------------------------------------------------//

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        petUtilityService.deleteById(id);
    }

    //-------------------------------------------------------------------------------//


}
