package com.example.PetHostel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


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

    //?Is Enumerated annotation necessary?
    @OneToMany(mappedBy = "reservation")
    private List<PetUtility> utilities;

    @ManyToOne
    @JoinColumn(name = "pet_owner_id")
    private PetOwner petOwner;

    @Transient
    private Integer periodLength;

    @Transient
    private Integer price;

    public Reservation(LocalDate startingDate, LocalDate finishingDate, List<PetUtility> utilities, Integer periodLength) {
        this.startingDate = startingDate;
        this.finishingDate = finishingDate;
        this.utilities = utilities;
        this.periodLength = periodLength;
    }

}
