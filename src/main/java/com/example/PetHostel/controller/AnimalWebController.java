package com.example.PetHostel.controller;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimalWebController {

    @Autowired
    AnimalService animalService;

    @RequestMapping("/cathostel/web/animal")
    public String animals(Model model) {
        model.addAttribute("myAnimals", animalService.findAll());
        return "animals";
    }


}
