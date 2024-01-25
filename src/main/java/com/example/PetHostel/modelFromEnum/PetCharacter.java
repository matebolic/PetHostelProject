package com.example.PetHostel.modelFromEnum;

public enum PetCharacter {
    KIND(4),
    NORMAL(2),
    AGRESSIVE(1);

    private Integer NumberOfMaxNumberOfAnimalPerStorage;

    PetCharacter(Integer numberOfMaxNumberOfAnimalPerStorage) {
        NumberOfMaxNumberOfAnimalPerStorage = numberOfMaxNumberOfAnimalPerStorage;
    }
}
