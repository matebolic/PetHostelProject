package com.example.PetHostel.service;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public Animal save (Animal animal) {
        return animalRepository.save(animal);
    }

    public  List<Animal> findAll() {
        return animalRepository.findAll();
    }


    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow();
    }

    public List<Animal> findByOwnerId(Long id) {
        return animalRepository.findByOwnerId(id);
    }

    public List<Animal> findByTheOwnersFullName(String fullName) {
        return animalRepository.findByTheOwnersFullName(fullName);
    }



}
