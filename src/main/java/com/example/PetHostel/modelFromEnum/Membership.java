package com.example.PetHostel.modelFromEnum;

import lombok.Getter;

@Getter
public enum Membership {
    NONE("none", 0, 0.0, 0),
    BASIC("basic", 1, 5.0, 5),
    STANDARD("standard", 2, 10.0, 10),
    PREMIUM("premium", 3, 20.0, 20);

    private String nameOfLevel;
    private Integer levelOfMembership;
    private Double percentageOfDiscount;
    private Integer minMembershipPoints;


    Membership(String nameOfLevel, Integer levelOfMembership, Double percentageOfDiscount, Integer minMembershipPoints) {
        this.nameOfLevel = nameOfLevel;
        this.levelOfMembership = levelOfMembership;
        this.percentageOfDiscount = percentageOfDiscount;
        this.minMembershipPoints = minMembershipPoints;
    }
}
