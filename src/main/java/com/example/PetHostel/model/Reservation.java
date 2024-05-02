package com.example.PetHostel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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

    private LocalDateTime startingDateTime;

    @Transient
    private LocalDate startingDate;

    @Transient
    private LocalTime startingTime;

    private LocalDateTime finishingDateTime;

    @Transient
    private LocalDate finishingDate;

    @Transient
    private LocalTime finishingTime;

    @ManyToOne
    @JoinColumn(name = "pet_owner_id")
    private PetOwner petOwner;

    @JsonIgnore
    @OneToMany(mappedBy = "reservation")
    private List<PetService> utilities;

    private Integer price;

    @JsonIgnore
    private List<Long> animalsPerReservationsList = new ArrayList<>();
    //mapped by id!

    public Reservation(PetOwner petOwner, String startingDateStr, String startingTimeStr, String finishingDateStr, String finishingTimeStr) {
        this.petOwner = petOwner;
        this.startingDate = LocalDate.parse(startingDateStr);
        this.startingTime = LocalTime.parse(startingTimeStr);
        this.finishingDate = LocalDate.parse(finishingDateStr);
        this.finishingTime = LocalTime.parse(finishingTimeStr);
        this.startingDateTime = LocalDateTime.of(this.startingDate, this.startingTime);
        this.finishingDateTime = LocalDateTime.of(this.finishingDate, this.finishingTime);
    }

    public void addAnimal(Animal animal) {
        this.animalsPerReservationsList.add(animal.getId());
    }
    //to avoid creating multiple animal objects

    public Double generatePrice() {
        return null;
        //setter?-----------------------------------------------------
    }


}
