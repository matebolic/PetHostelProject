package com.example.PetHostel.service;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public  List<Animal> findAll() {
        return animalRepository.findAll();
    }


}
