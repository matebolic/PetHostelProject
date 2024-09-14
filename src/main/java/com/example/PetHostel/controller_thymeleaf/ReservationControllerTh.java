package com.example.PetHostel.controller_thymeleaf;

import com.example.PetHostel.controller.AnimalController;
import com.example.PetHostel.model.Animal;
import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.model.PetServices;
import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.service.AnimalService;
import com.example.PetHostel.service.PetOwnerService;
import com.example.PetHostel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/th/pethostel/reservation/")
public class ReservationControllerTh {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AnimalService animalService;
    @Autowired
    PetOwnerService petOwnerService;


    @PostMapping("/addByUserName")
    public String getForm(@RequestParam("selectedUserNameString") String selectedUserNameString, Model model) {
        PetOwner petOwner = petOwnerService.findByUserName(selectedUserNameString);
        model.addAttribute("animals", petOwner.getAnimals());
        model.addAttribute("user", petOwner);
        return "reservation_new";
    }

    @PostMapping("/add")
    public String acceptForm(Model model,
                             @RequestParam("hiddenUserName") String hiddenUserName,
                             @RequestParam("isFoodTaken") String isFoodTakenString,
                             @RequestParam("daterange") String daterange,
                             @RequestParam("selectedAnimals") List<String> selectedAnimalList) {

        String[] dates = daterange.split("-");
        LocalDateTime arrivalTime = LocalDateTime.parse(dates[0]);
        LocalDateTime departureTime = LocalDateTime.parse(dates[1]);
        PetOwner petOwner = petOwnerService.findByUserName(hiddenUserName);
        boolean isFoodTaken = isFoodTakenString.equals("on");   //by definition "on" is the value of the form

        model.addAttribute("reservation", reservationService.processReservation(isFoodTaken,petOwner,selectedAnimalList, arrivalTime, departureTime));
        return "reservation_confirmation";
    }

}
