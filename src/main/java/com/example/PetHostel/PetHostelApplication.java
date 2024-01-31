package com.example.PetHostel;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.modelFromEnum.PetCharacter;
import com.example.PetHostel.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetHostelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetHostelApplication.class, args);
    }


    @Autowired
    private AnimalRepository animalRepository;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("Welcome in PetHostel terminal! Ready to work.");
            for (int i = 0; i < 10; i++) {
                animalRepository.save(new Animal().randomDetailedInfo());

            };
//            animalRepository.save(new Animal.AnimalBuilder(5L, "Micike").addDetailedInfo(5, Gender.FEMALE, true, PetCharacter.NORMAL).build());
//            animalRepository.save(new Animal.AnimalBuilder(4L, "Kormi").addDetailedInfo(1, Gender.MALE, false, PetCharacter.KIND).addOptionalInfo("Likes very much his games", null).build());
        };
    }


}
