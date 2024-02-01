package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.UtilityOptions;
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

    PetUtility(UtilityOptions utilityOptions, Reservation reservation) {
        this.servicePrice = utilityOptions.getPriceOfService();
        this.serviceName = utilityOptions.getServiceName();
        this.reservation = reservation;
    }

}
