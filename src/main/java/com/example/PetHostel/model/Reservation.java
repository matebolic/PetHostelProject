package com.example.PetHostel.model;

import com.example.PetHostel.function.DataInitializer;
import com.example.PetHostel.modelFromEnum.Currency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Accessors(chain = true)    //for fluent API usage
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
    private List<PetServices> services;

    private Integer priceOfReservation;

    private Long duration;

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
        this.duration = Duration.between(startingDateTime, finishingDateTime).toMinutes();
    }

    public Reservation calculateDuration() {
        this.setDuration(Duration.between(startingDateTime, finishingDateTime).toMinutes());
        return this;
    }


    public Reservation calculateTotalPriceByReservation() {
        Currency currencyToConvert = this.petOwner.getCurrency();

        Double priceDouble = this.services.stream()
                .map(service -> service.getPrice() * service.getNumberOfServicesPerReservation() * Currency.convertCurrency(service.getCurrency(), currencyToConvert))
                .reduce(0.0, (a, b) -> a + b);

        this.setPriceOfReservation(priceDouble.intValue());
        return this;
    }

    //    private List<PetServices> calculateServicesByElapsedTime() {
//        long v1, v2;
//        //v1: 0-12 h
//        //v2 12-24 h
//        v1 = this.duration % (24 * 60);
//        v2 = (this.duration - v1 * 60) % 60;
//        this.services.add(new PetServices())
//    }


    public Reservation calculateMembershipPoints() {
        this.getPetOwner().setMembershipPoints(this.petOwner.getMembershipPoints() + 1);
        return this;
    }

}
