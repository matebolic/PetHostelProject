package com.example.PetHostel.controller_thymeleaf;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.modelFromEnum.Currency;
import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.service.AnimalService;
import com.example.PetHostel.service.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/th/pethostel/animal/")


public class AnimalControllerTh {

    @Autowired
    AnimalService animalService;
    @Autowired
    PetOwnerService petOwnerService;

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("animal", animalService.findById(id));
        return "pet_info";
    }

    @GetMapping("/findByPetName/{petName}")
    public String findByPetName(@PathVariable String petName, Model model) {
        model.addAttribute("animal", animalService.findByPetName(petName).getFirst());
        return "pet_info";
    }

    @PostMapping("/addByUserName")
    public String getForm(@RequestParam("selectedUserNameString") String selectedUserNameString, Model model) {
        Animal animal = new Animal();
        PetOwner petOwner = petOwnerService.findByUserName(selectedUserNameString);
        model.addAttribute("animal", animal);
        model.addAttribute("genders", Gender.values());
        model.addAttribute("user", petOwner);
        return "pet_registration";
    }

    @PostMapping("/add")
    public String acceptForm(@ModelAttribute("animal") Animal animal, @RequestParam("hiddenUserName") String hiddenUserName) {
        PetOwner petOwner = petOwnerService.findByUserName(hiddenUserName);
        animal.setPetOwner(petOwner);
        animalService.save(animal);
        return "pet_info";
    }

    @GetMapping("/findAll")
    public String listAllAnimal(Model model) {
        model.addAttribute("animals", animalService.findAll());
        return "pets_info";
    }



}
