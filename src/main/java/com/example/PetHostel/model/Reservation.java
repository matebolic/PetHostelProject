package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.PetService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private LocalDate startingDate;
    @Column(nullable = false)
    private LocalDate finishingDate;
    @Transient
    private List<PetService> orderedPetServices;
    @Transient
    private Integer periodLength;

    public Reservation(LocalDate startingDate, LocalDate finishingDate, List<PetService> orderedPetServices, Integer periodLength) {
        this.startingDate = startingDate;
        this.finishingDate = finishingDate;
        this.orderedPetServices = orderedPetServices;
        this.periodLength = periodLength;
    }

}
