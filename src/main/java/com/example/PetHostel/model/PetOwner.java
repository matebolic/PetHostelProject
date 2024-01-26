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
    @Enumerated(EnumType.STRING)
    private Membership membership;

    public PetOwner() {
    }

     /* private List<Reservation> reservations;
    private Long accountBalance;
    private Double actualLocationX;
    private Double actualLocationY;
    private List<Animal> petList;*/

    public PetOwner(String firstName, String lastName, String dateString, Membership membership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateString);
        this.membership = membership;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

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
