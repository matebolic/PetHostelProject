package com.example.PetHostel;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.model.PetUtility;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.modelFromEnum.Currency;
import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.model.UtilityInfo;
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
    PetUtilityRepository petUtilityRepository;

    @Autowired
    UtilityInfoRepository utilityInfoRepository;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("Welcome in PetHostel terminal! Ready to work.");

            String descriptionBoarding = "Our boarding facility is fully equipped; with inox bowles " +
                    "for food and water, pet beds with soft blankets, various types of toys. We" +
                    " use premium quality cat food so the furry baby can arrive with his / her vaccination" +
                    " record book only.";

            String descriptionDaycare = "We can call our daycare an active daycare, because in our playground the cats" +
                    " can play all day outside in the nature and they have enormous place for running. But when" +
                    " we have rainy cold days they can play inside the heated house with confortable places, and" +
                    " the inner closed playground.";

            String descriptionWalking = "Upon a thorough," +
                    " complex selection process we employ college students that are cat owners themselves and are familiar with cats," +
                    " their behaviour / signals and are able to handle unexpected situations. In order that the cat walker does the job" +
                    " properly, we recommend the owner and the cat a personal meeting with him / her first. It is essential that the owner provides" +
                    " all necessary info to the walker about the cat, his/her nature, habits.";

            String descriptionTraining = "On occasions we have organized group trainings held by our trainers.";

            String descriptionGrooming = "A clean cat is a happy cat, and we're here to help! From nail trims to bathing, a little maintenance goes a long way.";


            //creating UtilityInfos
            UtilityInfo boarding = new UtilityInfo("boarding", descriptionBoarding, Currency.HUF, 5000);
            UtilityInfo daycare = new UtilityInfo("daycare", descriptionDaycare, Currency.HUF, 6000);
            UtilityInfo walking = new UtilityInfo("walking", descriptionWalking, Currency.HUF, 2000);
            UtilityInfo training = new UtilityInfo("training", descriptionTraining, Currency.HUF, 3000);
            UtilityInfo grooming = new UtilityInfo("grooming", descriptionGrooming, Currency.HUF, 4500);

            utilityInfoRepository.save(boarding);
            utilityInfoRepository.save(daycare);
            utilityInfoRepository.save(walking);
            utilityInfoRepository.save(training);
            utilityInfoRepository.save(grooming);

            PetOwner petOwner_mb = new PetOwner("George", "Best", "1981-10-11");
            PetOwner petOwner_mtb = new PetOwner("Barbara", "Swenson", "1981-06-27");
            petOwnerRepository.save(petOwner_mb);
            petOwnerRepository.save(petOwner_mtb);

            Animal cirmir = new Animal.AnimalBuilder().addBasicInfo(petOwner_mb, "Cirmir").addDetailedInfo(1, Gender.MALE, false).build();
            animalRepository.save(cirmir);

            for (int i = 0; i < 10; i++) {
                if (i < 5) {
                    animalRepository.save(new Animal().randomDetailedInfo()).setPetOwner(petOwner_mb);
                } else {
                    animalRepository.save(new Animal().randomDetailedInfo()).setPetOwner(petOwner_mtb);
                }

            }

            Reservation reservation01 = new Reservation(petOwner_mb, "2024-01-22", "2024-02-03");
            Reservation reservation02 = new Reservation(petOwner_mb, "2024-02-22", "2024-04-03");


            reservationRepository.save(reservation01);
            reservationRepository.save(reservation02);

            petUtilityRepository.save(new PetUtility(reservation01, boarding));
            petUtilityRepository.save(new PetUtility(reservation01, daycare));

            petUtilityRepository.save(new PetUtility(reservation02, grooming));

            System.out.println("Succesfully finished with CommandLineRunner.");

        };
    }


}
