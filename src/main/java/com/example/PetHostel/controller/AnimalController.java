package com.example.PetHostel.controller;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cathostel/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/findByPetName/{petName}")
    public Animal findByPetName(@PathVariable String petName) {
        return animalService.findByPetName(petName).getFirst();
    }

    /*
    Methods should have checked  - It was all written at the beginning:
    ------------------------------------------------------------
    */

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal) {
        return animalService.save(animal);
    }


    @GetMapping("/findAll")
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Animal findById(@PathVariable Long id) {
        return animalService.findById(id);
    }


    @GetMapping("/findByName")
    public List<Animal> findByPetNameIgnoreCase(String petName) {
        return animalService.findByPetNameIgnoreCase(petName);
    }


    @GetMapping("/findByOwnerFullName/{fullName}")
    public List<Animal> findByTheOwnerFullName(@PathVariable String fullName) {
        return animalService.findByTheOwnerFullName(fullName);
    }

    @GetMapping("/averageAge")
    public String getAvgAgeOfAnimal() {
        return animalService.getAvgAgeOfAnimal();
    }


}
