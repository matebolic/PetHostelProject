package com.example.PetHostel.function;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.model.PetUtility;
import com.example.PetHostel.model.Reservation;
import com.example.PetHostel.modelFromEnum.Currency;
import com.example.PetHostel.modelFromEnum.Gender;
import com.example.PetHostel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final PetUtilityRepository petUtilityRepository;
    private final PetOwnerRepository petOwnerRepository;
    private final AnimalRepository animalRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public DataInitializer(PetUtilityRepository petUtilityRepository, PetOwnerRepository petOwnerRepository, AnimalRepository animalRepository, ReservationRepository reservationRepository) {
        this.petUtilityRepository = petUtilityRepository;
        this.petOwnerRepository = petOwnerRepository;
        this.animalRepository = animalRepository;
        this.reservationRepository = reservationRepository;
    }

    public void saveTestEntities() {

        PetOwner petOwner_mb = new PetOwner("Matthieu", "Blaise", "1981-10-11", Currency.HUF);
        PetOwner petOwner_mtb = new PetOwner("Barbara", "Swenson", "1981-06-27", Currency.HUF);
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

        Reservation reservation01 = new Reservation(petOwner_mb, "2024-01-22", "18:00", "2024-02-03", "08:00");
        Reservation reservation02 = new Reservation(petOwner_mb, "2024-03-22", "14:00", "2024-04-07", "09:00");
        reservationRepository.save(reservation01);
        reservationRepository.save(reservation02);
    }

    public void savePetUtility() {

        String descriptionBoarding = "Our boarding facility is fully equipped; with inox bowles " +
                "for food and water, pet beds with soft blankets, various types of toys. We" +
                " use premium quality cat food so the furry baby can arrive with his / her vaccination" +
                " record book only.";

        String descriptionDaycare = "We can call our daycare an active daycare, because in our playground the cats" +
                " can play all day outside in the nature and they have enormous place for running. But when" +
                " we have rainy cold days they can play inside the heated house with confortable places, and" +
                " the inner closed playground.";

        String descriptionWalk = "We walk with cats in our wonderful neihgbourhood. We only use the cats' own accessories";

        PetUtility boarding = new PetUtility("boarding", descriptionBoarding, Currency.HUF, 5000);
        PetUtility daycare = new PetUtility("daycare", descriptionDaycare, Currency.HUF, 6000);
        PetUtility walk = new PetUtility("walk", descriptionWalk, Currency.HUF, 2000);

        petUtilityRepository.save(boarding);
        petUtilityRepository.save(daycare);
        petUtilityRepository.save(walk);
    }

}
