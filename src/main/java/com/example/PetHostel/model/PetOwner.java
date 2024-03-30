package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Membership;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(nullable = false, length = 30)
    private String firstName;
    @Column(nullable = false, length = 30)
    private String lastName;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Membership membership;
    private Integer membershipPoints;

    @JsonIgnore
    @OneToMany(mappedBy = "petOwner")
    private List<Reservation> reservations;

    @JsonIgnore
    @OneToMany(mappedBy = "petOwner")
    private List<Animal> animals;


//    private Long accountBalance;
//    private Double actualLocationX;
//    private Double actualLocationY;


    public PetOwner(String firstName, String lastName, String dateString) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateString);
        this.membershipPoints = 0;  //initial value
    }

}
