package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Currency;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class UtilityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long utilityId;

    private String serviceName;

    private String description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Integer priceOfService;

    private LocalDate dateOfLastPriceModification;


    public UtilityInfo(String serviceName, String description, Currency currency, Integer priceOfService) {
        this.serviceName = serviceName;
        this.description = description;
        this.currency = currency;
        this.priceOfService = priceOfService;
        this.dateOfLastPriceModification = LocalDate.now();
    }
}
