package com.example.PetHostel;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.modelFromEnum.Membership;
import com.example.PetHostel.repository.AnimalRepository;
import com.example.PetHostel.repository.PetOwnerRepository;
import com.example.PetHostel.repository.ReservationRepository;
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
    @Autowired
    PetOwnerRepository petOwnerRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("Welcome in PetHostel terminal! Ready to work.");
            for (int i = 0; i < 10; i++) {
                animalRepository.save(new Animal().randomDetailedInfo());
            }

            PetOwner petOwner_mb = new PetOwner("Balázs", "Máté", "1987-10-15", Membership.BASIC);
            PetOwner petOwner_mtb = new PetOwner("Barbara", "Máté-Turuczkai", "1991-08-27");
            petOwnerRepository.save(petOwner_mb);
            petOwnerRepository.save(petOwner_mtb);
            reservationRepository.save(new Reservation("2024-01-22", "2024-01-25", petOwner_mb));


                    System.out.println("Succesfully finished with CommandLineRunner.");
            //            animalRepository.save(new Animal.AnimalBuilder(5L, "Micike").addDetailedInfo(5, Gender.FEMALE, true, PetCharacter.NORMAL).build());
//            animalRepository.save(new Animal.AnimalBuilder(4L, "Kormi").addDetailedInfo(1, Gender.MALE, false, PetCharacter.KIND).addOptionalInfo("Likes very much his games", null).build());
        };
    }


}
