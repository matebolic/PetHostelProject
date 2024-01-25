package com.example.PetHostel.modelFromEnum;

public enum Membership {
    BASIC(1, 5.0, 5),
    STANDARD(2, 10.0, 10),
    PREMIUM(3, 20.0,20);

    private Integer levelOfMembership;
    private Double percentageOfDiscount;
    private Integer stepsToUpgrade;

    Membership(Integer levelOfMembership, Double percentageOfDiscount, Integer stepsToUpgrade) {
        this.levelOfMembership = levelOfMembership;
        this.percentageOfDiscount = percentageOfDiscount;
        this.stepsToUpgrade = stepsToUpgrade;
    }
}
