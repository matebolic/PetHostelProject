package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.modelFromEnum.PetCharacter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
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
    private Long ownerId;
    @Column(nullable = false)
    private String petName;

    //DetailedInfo
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Boolean isNeutered;
    @Enumerated(EnumType.STRING)
    private PetCharacter petCharacter;

    //OptionalInfo
    private String specialNeeds;
    private String pictureURL;      //picture URL from a web API

    public Animal(Long ownerId, String petName, Integer age, Gender gender, Boolean isNeutered, PetCharacter petCharacter) {
        this.ownerId = ownerId;
        this.petName = petName;
        this.age = age;
        this.gender = gender;
        this.isNeutered = isNeutered;
        this.petCharacter = petCharacter;
    }

    public static class AnimalBuilder {
        private Long ownerId;
        private String petName;
        private Integer age;
        private Gender gender;
        private Boolean isNeutered;
        private PetCharacter petCharacter;
        private String specialNeeds;
        private String pictureURL;

        public AnimalBuilder(Long ownerId, String petName) {
            this.ownerId = ownerId;
            this.petName = petName;
        }

        public AnimalBuilder addDetailedInfo(Integer age, Gender gender, Boolean isNeutered, PetCharacter petCharacter) {
            this.age = age;
            this.gender = gender;
            this.isNeutered = isNeutered;
            this.petCharacter = petCharacter;
            return this;
        }

        public AnimalBuilder addOptionalInfo(String specialNeeds, String pictureURL) {
            this.specialNeeds = specialNeeds;
            this.pictureURL = pictureURL;
            return this;
        }

        public Animal build() {
            Animal animal = new Animal();
            animal.ownerId = this.ownerId;
            animal.petName = this.petName;
            animal.age = this.age;
            animal.gender = this.gender;
            animal.isNeutered = this.isNeutered;
            animal.petCharacter = this.petCharacter;
            animal.specialNeeds = this.specialNeeds;
            animal.pictureURL = this.pictureURL;
            return animal;
        }
    }

    //randomData

    public Animal randomDetailedInfo() {
        this.setOwnerId(randomizeOwnerId());
        this.setPetName(randomizePetName());
        this.setAge(randomizeAge());
        this.setGender(randomizeGender());
        this.setIsNeutered(randomizeNeutered());
        this.setPetCharacter(randomizePetCharacter());
        return this;
    }

    public Long randomizeOwnerId() {
        return 1L;
    }       //from the available ID-s! request!!!!!!!!

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

    public PetCharacter randomizePetCharacter() {
        return PetCharacter.values()[ThreadLocalRandom.current().nextInt(0, PetCharacter.values().length)];
    }

}
