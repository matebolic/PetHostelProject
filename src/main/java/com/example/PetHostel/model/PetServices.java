package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Currency;
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

    private String description;

    private Integer price;
    /*
    #T001 - currency change is needed according to the users default/choosen currency
     it has to be converted from the base currency
     */

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public PetServices(PetUtility petUtility) {
        this.serviceName = petUtility.getUtilityName();
        this.description = petUtility.getDescription();
        this.price = petUtility.getPrice();
        //#T001 - currency change is needed
    }

}
