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
public class PetUtility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceId;
    private String serviceName;
    private Integer servicePrice;

    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    public PetUtility(Reservation reservation, UtilityInfo utilityInfo) {
        this.reservation = reservation;
        this.servicePrice = utilityInfo.getPriceOfService();
        this.serviceName = utilityInfo.getServiceName();
    }

}
