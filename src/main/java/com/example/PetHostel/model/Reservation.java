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

    @ManyToOne
    @JoinColumn(name = "pet_owner_id")
    private PetOwner petOwner;

    @JsonIgnore
    @OneToMany(mappedBy = "reservation")
    private List<PetUtility> utilities;

    @Transient
    private Integer periodLength;

    @Transient
    private Integer price;

    @JsonIgnore
    private List<Long> animalsPerReservationsList;
    //mapped by id!

    public Reservation(PetOwner petOwner, String startingDateStr, String finishingDateStr) {
        this.startingDate = LocalDate.parse(startingDateStr);
        this.finishingDate = LocalDate.parse(finishingDateStr);
        this.periodLength = Math.toIntExact(finishingDate.toEpochDay() - startingDate.toEpochDay());
    }

    public Integer getPeriodLength() {
        return Math.toIntExact(this.finishingDate.toEpochDay() - this.startingDate.toEpochDay());
    }

    public Double generatePrice() {
        return null;
    }


}
