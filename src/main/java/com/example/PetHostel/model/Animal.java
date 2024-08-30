package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //BasicInfo
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_owner_id")
    private PetOwner petOwner;

    @Column(nullable = false)
    private String petName;

    //DetailedInfo
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean isNeutered;

    //OptionalInfo
    private String specialNeeds;

    private String pictureURL;      //picture URL from a web API

    public Animal(PetOwner petOwner, String petName, Integer age, Gender gender, Boolean isNeutered) {
        this.petOwner= petOwner;
        this.petName = petName;
        this.age = age;
        this.gender = gender;
        this.isNeutered = isNeutered;
    }

    public Animal(String petName, Integer age, Gender gender, Boolean isNeutered) {
        this.petName = petName;
        this.age = age;
        this.gender = gender;
        this.isNeutered = isNeutered;
    }

    public static class AnimalBuilder {
        private PetOwner petOwner;
        private String petName;
        private Integer age;
        private Gender gender;
        private Boolean isNeutered;
         private String specialNeeds;
        private String pictureURL;

        public AnimalBuilder addBasicInfo(PetOwner petOwner, String petName) {
            this.petOwner = petOwner;
            this.petName = petName;
            return this;
        }

        public AnimalBuilder addDetailedInfo(Integer age, Gender gender, Boolean isNeutered) {
            this.age = age;
            this.gender = gender;
            this.isNeutered = isNeutered;
            return this;
        }

        public AnimalBuilder addOptionalInfo(String specialNeeds, String pictureURL) {
            this.specialNeeds = specialNeeds;
            this.pictureURL = pictureURL;
            return this;
        }

        public Animal build() {
            Animal animal = new Animal();
            animal.petOwner = this.petOwner;
            animal.petName = this.petName;
            animal.age = this.age;
            animal.gender = this.gender;
            animal.isNeutered = this.isNeutered;
            animal.specialNeeds = this.specialNeeds;
            animal.pictureURL = this.pictureURL;
            return animal;
        }
    }

    //randomData

    /**
     *Differs from the addDetailedInfo by the petname, here that is also a random property
     * @return An animal object with random - name, age, gender, state of sterilization
     */
    public Animal randomDetailedInfo() {
        this.setPetName(randomizePetName());
        this.setAge(randomizeAge());
        this.setGender(randomizeGender());
        this.setIsNeutered(randomizeNeutered());
        return this;
    }

    public Long randomizeOwnerId() {
        return ThreadLocalRandom.current().nextLong(1, 4);
    }

    public String randomizePetName() {
        List<String> randomNameSyllables = List.of("mi", "ma", "ci", "ca", "cat", "sy", "cir", "mir", "mir", "kor", "mir");
        return this.petName = randomNameSyllables.get(ThreadLocalRandom.current().nextInt(0, randomNameSyllables.size())) +
                randomNameSyllables.get(ThreadLocalRandom.current().nextInt(0, randomNameSyllables.size()));
    }

    public Integer randomizeAge() {
        return ThreadLocalRandom.current().nextInt(1, 21);
    }

    public Gender randomizeGender() {
        return Gender.values()[ThreadLocalRandom.current().nextInt(0, 2)];
    }

    public Boolean randomizeNeutered() {
        return ThreadLocalRandom.current().nextInt(0, 2) != 0;
    }

}
