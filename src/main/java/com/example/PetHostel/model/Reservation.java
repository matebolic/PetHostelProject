package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.PetService;

import java.time.LocalDate;
import java.util.List;

public class Reservation {

    private LocalDate startingDate;
    private LocalDate finishingDate;
    private List<PetService> orderedPetServices;


}
