package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.modelFromEnum.PetCharacter;
import jakarta.persistence.*;

@Entity
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private PetOwner petOwner;
    private String petName;
    private Integer age;
    private Gender gender;
    private Boolean isNeutered;
    private PetCharacter petCharacter;
    private String specialNeeds;

    //picture URL from a web API
    private String pictureURL;

}
