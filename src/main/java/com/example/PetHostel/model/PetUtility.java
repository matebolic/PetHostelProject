package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Currency;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class PetUtility {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long utilityId;

    private String utilityName;

    @Column(columnDefinition = "TEXT")
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
