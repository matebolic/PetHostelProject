package com.example.PetHostel.model;

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

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public PetServices(PetUtility petUtility) {
        this.price = petUtility.getPrice();
        this.serviceName = petUtility.getUtilityName();
    }

}
