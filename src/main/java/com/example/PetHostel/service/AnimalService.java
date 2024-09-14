package com.example.PetHostel.service;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> findByPetName(String petName) {
        return animalRepository.findByPetName(petName);
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal save(Animal animal) {
        if (animal.getIsNeutered() == null) {
            animal.setIsNeutered(false);
        }
        return animalRepository.save(animal);
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow();
    }


       /*
    Methods should have checked  - It was all written at the beginning:
    ------------------------------------------------------------
    */

    public List<Animal> findByPetNameIgnoreCase(String petName) {
        return animalRepository.findByPetNameIgnoreCase(petName);
    }

    public List<Animal> findByTheOwnerFullName(String fullName) {
        return animalRepository.findByTheOwnerFullName(fullName);
    }

    public String getAvgAgeOfAnimal() {
        return animalRepository.findAll().stream().map(animal -> animal.getAge()).mapToInt(a -> a).summaryStatistics().toString();
    }


}
