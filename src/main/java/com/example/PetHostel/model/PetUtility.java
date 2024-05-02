package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Currency;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class PetUtility {

    public static LocalTime daycareStartingTime = LocalTime.parse("8:00");
    public static LocalTime boardingStartingTime = LocalTime.parse("20:00");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long utilityId;

    private String utilityName;

    private String description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Integer price;

    private LocalDate dateOfLastPriceModification;


    public PetUtility(String utilityName, String description, Currency currency, Integer price) {
        this.utilityName = utilityName;
        this.description = description;
        this.currency = currency;
        this.price = price;
        this.dateOfLastPriceModification = LocalDate.now();
    }
}
