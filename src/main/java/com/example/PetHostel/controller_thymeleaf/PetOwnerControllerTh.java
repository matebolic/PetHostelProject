package com.example.PetHostel.controller_thymeleaf;

import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.modelFromEnum.Currency;
import com.example.PetHostel.service.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/th/pethostel/user/")

public class PetOwnerControllerTh {

    @Autowired
    PetOwnerService petOwnerService;

    @GetMapping("/findByUserName/{username}")
    public String findByUserName(@PathVariable String username, Model model) {
        model.addAttribute("user", petOwnerService.findByUserName(username));
        return "owner_info";
    }


    @GetMapping("/add")
    public String getForm(Model model) {
        PetOwner petOwner = new PetOwner();
        model.addAttribute("user", petOwner);
        model.addAttribute("currencies", Currency.values());
        return "owner_registration";
    }

    @PostMapping("/add")
    public String acceptForm(@ModelAttribute("user") PetOwner petOwner, @RequestParam String dateOfBirthString) {
        System.out.println(dateOfBirthString);
        petOwner.setDateOfBirth(LocalDate.parse("1991-01-01"));
        petOwnerService.save(petOwner);
        return "owner_info";
    }

    @GetMapping("/all")
    public String checkAllUser(Model model) {
        model.addAttribute("owners", petOwnerService.findAll());
        return "owners_info";
    }


}
