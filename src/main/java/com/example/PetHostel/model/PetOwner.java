package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Membership;

import java.time.LocalDate;
import java.util.List;

public class PetOwner {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<Reservation> reservations;
    private Long accountBalance;
    private Double actualLocationX;
    private Double actualLocationY;
    private Membership membership;
    private List<Animal> petList;


}
