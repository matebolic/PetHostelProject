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

    private final AnimalRepository animalRepository;
    private final PetOwnerRepository petOwnerRepository;
    private final ReservationRepository reservationRepository;
    private final PetServicesRepository petServicesRepository;
    private final PetUtilityRepository petUtilityRepository;

    @Autowired
    public PetHostelApplication(AnimalRepository animalRepository,
                                PetOwnerRepository petOwnerRepository,
                                ReservationRepository reservationRepository,
                                PetServicesRepository petServicesRepository,
                                PetUtilityRepository petUtilityRepository) {
        this.animalRepository = animalRepository;
        this.petOwnerRepository = petOwnerRepository;
        this.reservationRepository = reservationRepository;
        this.petServicesRepository = petServicesRepository;
        this.petUtilityRepository = petUtilityRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PetHostelApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {

            System.out.println("-".repeat(40));
            System.out.println("Welcome in PetHostel terminal! Ready to work.");
            System.out.println("-".repeat(40));

            Initializer initializer = new Initializer(
                    petOwnerRepository,
                    animalRepository,
                    reservationRepository,
                    petServicesRepository,
                    petUtilityRepository
            );
            initializer.saveTestEntities();
//            initializer.savePetUtility();

            System.out.println("Successfully finished with CommandLineRunner.");
        };
    }
}
