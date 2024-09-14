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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


@Getter
@Setter
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
    @ManyToMany
    @JoinTable(
            name = "reservation_animal",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id")
    )
    private List<Animal> animalsPerReservationsList = new ArrayList<>();

    //test: is it necessary to initialize the list earlier? Is there a better way ?
    public Reservation() {
        this.services = new ArrayList<>();
        this.animalsPerReservationsList = new ArrayList<>();
    }

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

    /**
     * @return an array, the first (index-0) is the number of boarding, the second is the number of daycare
     * We calculate the fees by the elapsed time of the pet's presence.
     * The first 12 hour costs the same, it is the price of daycare.
     * If the staying time exceeds 12 hours than it's price will be the boarding's price (12-24h).
     * After 24 hours it will cost a new daycare price again...";
     * e.g: 11h: 1 daycare; 13h: 1 boarding; 25h: 1 boarding, 1 daycare; 35h: 1 boarding + 1 daycare; 36h: 2 boarding;
     * duration is calculated by minutes
     */
    public int[] getNumberOfServicesFromDuration() {
        int[] numberOfServices = new int[]{0, 0};
        numberOfServices[0] = (int) (this.getDuration() / (24 * 60));
        double temporalValue = ((double) this.getDuration() / (24 * 60)) - numberOfServices[0];
        if (temporalValue > 0.5) {
            numberOfServices[0]++;
        } else if (temporalValue > 0 && temporalValue <= 0.5) {
            numberOfServices[1]++;
        }
        System.out.println(Arrays.toString(numberOfServices));
        System.out.println(temporalValue);
        return numberOfServices;
    }

    public Reservation calculateTotalPriceByReservation() {
        Currency currencyToConvert = this.petOwner.getCurrency();

        Double priceDouble = this.animalsPerReservationsList.size() * this.services.stream()
                .map(service -> service.getPrice() * service.getNumberOfServicesPerReservation() * Currency.convertCurrency(service.getCurrency(), currencyToConvert))
                .reduce(0.0, (a, b) -> a + b);

        this.setPriceOfReservation(priceDouble.intValue());
        return this;
    }

    public Reservation calculateMembershipPoints() {
        this.getPetOwner().setMembershipPoints(this.petOwner.getMembershipPoints() + 1);
        return this;
    }

}
