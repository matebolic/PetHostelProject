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

public class PetUtilityInfo {

    public static LocalTime daycareStartingTime = LocalTime.parse("8:00");
    public static LocalTime boardingStartingTime = LocalTime.parse("20:00");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long utilityId;

    private String serviceName;

    private String description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Integer priceOfService;

    private LocalDate dateOfLastPriceModification;


    public PetUtilityInfo(String serviceName, String description, Currency currency, Integer priceOfService) {
        this.serviceName = serviceName;
        this.description = description;
        this.currency = currency;
        this.priceOfService = priceOfService;
        this.dateOfLastPriceModification = LocalDate.now();
    }
}
