package com.example.PetHostel.controller;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.modelFromEnum.Membership;
import com.example.PetHostel.service.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cathostel/owner")
public class PetOwnerController {

    @Autowired
    PetOwnerService petOwnerService;

    //-------------------------------------------------------------------------------//

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public PetOwner save(@RequestBody PetOwner petOwner) {
        return petOwnerService.save(petOwner);
    }

    //-------------------------------------------------------------------------------//

    @GetMapping("/findAll")
    public List<PetOwner> findAll() {
        return petOwnerService.findAll();
    }


    @GetMapping("/findByFullName/{fullName}")
    public List<PetOwner> findByFullName(@PathVariable String fullName) {
        return petOwnerService.findByFullName(fullName);
    }


    //findByMembership - public on website
    @GetMapping("/findByMembership/{membershipStr}")
    public List<PetOwner> findByMembership(@PathVariable String membershipStr) {
        Membership membership = Arrays.stream(Membership.values()).filter(mb -> mb.getNameOfLevel().equals(membershipStr.toString())).findFirst().orElse(Membership.NONE);
        return petOwnerService.findByMembership(membership);
    }

    //admin queries!!

    //-------------------------------------------------------------------------------//

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public PetOwner update(@RequestBody PetOwner petOwner) {
        return petOwnerService.save(petOwner);
    }


    //-------------------------------------------------------------------------------//

    //with admin
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        petOwnerService.deleteById(id);
    }


}
