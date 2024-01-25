package com.example.PetHostel.modelFromEnum;

public enum PriceModifierPerAnimal {
    DOG("dog", 2.0),
    CAT("cat", 1.0),
    TURTLE("turtle", 2.5),
    ;
    private String animalName;
    private Double priceModifier;

    PriceModifierPerAnimal(String animalName, Double priceModifier) {
        this.animalName = animalName;
        this.priceModifier = priceModifier;
    }

}
