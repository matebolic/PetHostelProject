package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Membership;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
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

    @OneToMany(mappedBy = "petOwner")
    private List<Reservation> reservations;

    @Transient
    private List<Animal> petList;


//    private Long accountBalance;
//    private Double actualLocationX;
//    private Double actualLocationY;

    public PetOwner(String firstName, String lastName, String dateString, Membership membership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateString);
        this.membership = membership;
    }

}
