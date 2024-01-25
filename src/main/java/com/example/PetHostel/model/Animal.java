package com.example.PetHostel.model;

import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.modelFromEnum.PetCharacter;
import jakarta.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long ownerId;
    @Column(nullable = false)
    private String petName;

    //Detailed info
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Boolean isNeutered;
    @Enumerated(EnumType.STRING)
    private PetCharacter petCharacter;

    //OptionalInfo
    private String specialNeeds;
    private String pictureURL;      //picture URL from a web API


    public Animal() {
    }

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getNeutered() {
        return isNeutered;
    }

    public void setNeutered(Boolean neutered) {
        isNeutered = neutered;
    }

    public PetCharacter getPetCharacter() {
        return petCharacter;
    }

    public void setPetCharacter(PetCharacter petCharacter) {
        this.petCharacter = petCharacter;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", petName='" + petName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", isNeutered=" + isNeutered +
                ", petCharacter=" + petCharacter +
                ", specialNeeds='" + specialNeeds + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                '}';
    }
}
