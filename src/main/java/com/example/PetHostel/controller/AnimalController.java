package com.example.PetHostel.controller;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cathostel/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    //-------------------------------------------------------------------------------//

    @GetMapping("/findAll")
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Animal findById(@PathVariable Long id) {
        return animalService.findById(id);
    }

    @GetMapping("/findByOwnerId/{id}")
    public List<Animal> findByOwnerId(@PathVariable Long id) {
        return animalService.findByOwnerId(id);
    }

    @GetMapping("/findByOwnerFullName/{fullName}")
    public List<Animal> findByTheOwnersFullName(@PathVariable String fullName) {
        return animalService.findByTheOwnersFullName(fullName);
    }

    @GetMapping("/findByPetName/{petName}")
    public List<Animal> findByPetName(@PathVariable String petName) {
        return animalService.findByPetName(petName);
    }

    @GetMapping("/findNow")
    public List<Animal> findNow() {
        return animalService.findNow();
    }

    @GetMapping("/findByDates/{localDateStr}")
    public List<Animal> findByDates(@PathVariable String localDateStr) {
        return animalService.findByDates(LocalDate.parse(localDateStr));
    }

    //-------------------------------------------------------------------------------//

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        animalService.deleteById(id);
    }


}
