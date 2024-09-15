package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Currency;
import com.example.PetHostel.modelFromEnum.Membership;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String userName;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Membership membership;

    private Integer membershipPoints;

    private Currency currency;

    private Double balance;

    @JsonIgnore
    @OneToMany(mappedBy = "petOwner")
    private List<Reservation> reservations;

    @JsonIgnore
    @OneToMany(mappedBy = "petOwner")
    private List<Animal> animals;

    public PetOwner() {
        this.balance = 0.00;
        this.membershipPoints = 0;  //initial value
        this.membership = Membership.NONE;
    }

    public PetOwner(String userName, String firstName, String lastName, String dateString, Currency currency, String email, String password) {
        this.balance = 0.00;
        this.membershipPoints = 0;  //initial value
        this.membership = Membership.NONE;

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateString);
        this.currency = currency;
        this.email = email;
        this.password = password;
    }

    public PetOwner(String userName, String firstName, String lastName, String dateString, Currency currency, Double balance) {
        this.balance = 0.00;
        this.membershipPoints = 0;  //initial value
        this.membership = Membership.NONE;

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateString);
        this.currency = currency;
    }

    public PetOwner pay(int price) {
        this.balance -= price;
        return this;
    }

    public PetOwner calculateMembership() {
        int serialOfActualMembership = this.membership.ordinal();
        while (serialOfActualMembership < Membership.values().length - 1) {
            if (this.membershipPoints > Membership.values()[serialOfActualMembership + 1].getMinMembershipPoints()) {
                this.setMembership(Membership.values()[serialOfActualMembership + 1]);
            }
        }
        return this;
    }


}
