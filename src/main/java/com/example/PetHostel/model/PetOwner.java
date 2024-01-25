package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Membership;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 20)
    private String firstName;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    public PetOwner() {
    }

    public PetOwner(String firstName, String lastName, String dateString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateString);
    }


    /* private List<Reservation> reservations;
    private Long accountBalance;
    private Double actualLocationX;
    private Double actualLocationY;
    private Membership membership;
    private List<Animal> petList;*/

    @Override
    public String toString() {
        return "PetOwner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
