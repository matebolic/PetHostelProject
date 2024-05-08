package com.example.PetHostel;

import com.example.PetHostel.function.Initializer;
import com.example.PetHostel.model.*;
import com.example.PetHostel.modelFromEnum.Currency;
import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.repository.*;
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
    @Autowired
    PetServicesRepository petServicesRepository;

    @Autowired
    PetUtilityRepository petUtilityRepository;

    @Bean
    public CommandLineRunner runner() {
        return args -> {


            System.out.println("-".repeat(40));
            System.out.println("Welcome in PetHostel terminal! Ready to work.");
            System.out.println("-".repeat(40));

            PetOwner petOwner_mb = new PetOwner("Matthieu", "Blaise", "1981-10-11", Currency.HUF);
            PetOwner petOwner_mtb = new PetOwner("Barbara", "Swenson", "1981-06-27", Currency.HUF);
            petOwnerRepository.save(petOwner_mb);
            petOwnerRepository.save(petOwner_mtb);

            new Initializer().savePetUtility();

            Animal cirmir = new Animal.AnimalBuilder().addBasicInfo(petOwner_mb, "Cirmir").addDetailedInfo(1, Gender.MALE, false).build();
            animalRepository.save(cirmir);

            for (int i = 0; i < 10; i++) {
                if (i < 5) {
                    animalRepository.save(new Animal().randomDetailedInfo()).setPetOwner(petOwner_mb);
                } else {
                    animalRepository.save(new Animal().randomDetailedInfo()).setPetOwner(petOwner_mtb);
                }

            }

            Reservation reservation01 = new Reservation(petOwner_mb, "2024-01-22", "18:00", "2024-02-03", "8:00");
            Reservation reservation02 = new Reservation(petOwner_mb, "2024-03-22", "14:00", "2024-04-07", "9:00");
            reservationRepository.save(reservation01);
            reservationRepository.save(reservation02);

            System.out.println("Succesfully finished with CommandLineRunner.");

        };
    }


}
