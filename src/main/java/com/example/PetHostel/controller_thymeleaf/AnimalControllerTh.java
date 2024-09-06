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

    @PostMapping("/register")
    public String getFormByUser(@ModelAttribute("user") PetOwner petOwner, Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        model.addAttribute("gender", Gender.values());
        model.addAttribute("user", petOwner);
        return "pet_registration";
    }

    @PostMapping("/add")
    public String acceptForm(@ModelAttribute("animal") Animal animal, @RequestParam("hiddenUserName") String userName) {
        System.out.println("------------------------------------------" + userName);
        animal.setPetOwner(petOwnerService.findByUserName(userName));
        System.out.println(animal.getPetOwner().getUserName());
        animalService.save(animal);
        return "pet_info";
    }

    @PostMapping("/findByPetName/{petName}")
    public String findByPetName(@PathVariable String petName, Model model) {
        model.addAttribute("animal", animalService.findByPetName(petName));
        return "pet_info";
    }


}
