package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Currency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class PetServices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceId;

    private String serviceName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private Currency currency;
    /*
    #T001 - currency change is needed according to the users default/choosen currency
     it has to be converted from the base currency
     */

    private Integer price;

    private Integer numberOfServicesPerReservation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public PetServices(PetUtility petUtility) {
        this.serviceName = petUtility.getUtilityName();
        this.description = petUtility.getDescription();
        this.currency = petUtility.getCurrency();
        this.price = petUtility.getPrice();
    }

    public PetServices(PetUtility petUtility, Integer numberOfServicesPerReservation) {
        this.serviceName = petUtility.getUtilityName();
        this.description = petUtility.getDescription();
        this.currency = petUtility.getCurrency();
        this.price = petUtility.getPrice();
        this.numberOfServicesPerReservation = numberOfServicesPerReservation;
    }
}
