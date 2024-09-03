package com.example.PetHostel.modelFromEnum;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private String name;

    Gender(String name) {
        this.name = name;
    }
}
