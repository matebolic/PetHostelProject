package com.example.PetHostel.controller;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cathostel/")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/findAll")
    public List<Animal> findAll() {
       return animalService.findAll();
    }


}
