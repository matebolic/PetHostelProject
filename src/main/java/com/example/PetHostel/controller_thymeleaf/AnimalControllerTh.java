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

    @GetMapping("/findByPetName/{petName}")
    public String findByPetName(@PathVariable String petName, Model model) {
        model.addAttribute("animal", animalService.findByPetName(petName));
        return "pet_info";
    }

    @PostMapping("/addByUserName")
    public String getForm(@ModelAttribute("user") PetOwner petOwner, Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        model.addAttribute("genders", Gender.values());
        return "pet_registration";
    }

    @PostMapping("/addByUserNameByString")
    public String getFormByString(@RequestParam("selectedUserNameString") String selectedUserNameString, Model model) {
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
        return "index.html";
    }

    @GetMapping("/findAll")
    public String listAllAnimal(Model model) {
        model.addAttribute("animals", animalService.findAll());
        return "pets_info";
    }



}
