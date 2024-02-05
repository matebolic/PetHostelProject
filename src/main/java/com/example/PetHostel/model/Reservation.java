package com.example.PetHostel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private LocalDate startingDate;
    @Column(nullable = false)
    private LocalDate finishingDate;

    @JsonIgnore
    @OneToMany(mappedBy = "reservation")
    private List<PetUtility> utilities;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "pet_owner_id")
    private PetOwner petOwner;

    @Transient
    private Integer periodLength;

    @Transient
    private Integer price;


    public Reservation(String startingDateStr, String finishingDateStr, PetOwner petOwner) {
        this.startingDate = LocalDate.parse(startingDateStr);
        this.finishingDate = LocalDate.parse(finishingDateStr);
        this.periodLength = Math.toIntExact(finishingDate.toEpochDay() - startingDate.toEpochDay());
    }

    public Reservation(String startingDateStr, String finishingDateStr, PetOwner petOwner, Animal animal) {
        this.startingDate = LocalDate.parse(startingDateStr);
        this.finishingDate = LocalDate.parse(finishingDateStr);
        this.periodLength = Math.toIntExact(finishingDate.toEpochDay() - startingDate.toEpochDay());
        this.animal = animal;
    }

    public Integer getPeriodLength() {
        return Math.toIntExact(this.finishingDate.toEpochDay() - this.startingDate.toEpochDay());
    }
}
