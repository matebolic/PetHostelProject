package com.example.PetHostel.service;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    //-------------------------------------------------------------------------------//

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }


    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow();
    }

    public List<Animal> findByOwnerId(Long id) {
        return animalRepository.findByOwnerId(id);
    }

    public List<Animal> findByTheOwnerFullName(String fullName) {
        return animalRepository.findByTheOwnerFullName(fullName);
    }

    public List<Animal> findByPetName(String petName) {
        return animalRepository.findByPetNameIgnoreCase(petName);
    }

    public List<Animal> findNow() {
        return animalRepository.findNow();
    }


    public List<Animal> findByDates(LocalDate localDate) {
        return animalRepository.findByDates(localDate);
    }

    public String getAvgAgeOfAnimal() {
        return animalRepository.findAll().stream().map(animal -> animal.getAge()).mapToInt(a -> a).summaryStatistics().toString();
    }

    public Animal getActualYoungest() {
        return animalRepository.findAll().stream()
                .sorted(Comparator.comparing(a -> a.getAge()))
                .findFirst()
                .orElseThrow();
    }

    public Animal getActualOldest() {
        return animalRepository.findAll().stream()
                .sorted(new Comparator<Animal>() {
                    @Override
                    public int compare(Animal a1, Animal a2) {
                        return a1.getAge() > a2.getAge() ? -1 : 1;
                    }
                })
                .findFirst()
                .orElseThrow();
    }

    //-------------------------------------------------------------------------------//

    public void updateName(String name, Long id) {
        animalRepository.updateName(name, id);
    }


    //-------------------------------------------------------------------------------//

    public void deleteById(Long id) {
        animalRepository.deleteById(id);

    }

}
