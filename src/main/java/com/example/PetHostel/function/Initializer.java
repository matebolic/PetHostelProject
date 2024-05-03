package com.example.PetHostel.function;

import com.example.PetHostel.model.PetUtility;
import com.example.PetHostel.modelFromEnum.Currency;
import com.example.PetHostel.repository.PetUtilityRepository;
import com.example.PetHostel.service.PetUtilityService;
import org.springframework.beans.factory.annotation.Autowired;

public class Initializer {

    @Autowired
    PetUtilityRepository petUtilityRepository;

    public void savePetUtility() {

        String descriptionBoarding = "Our boarding facility is fully equipped; with inox bowles " +
                "for food and water, pet beds with soft blankets, various types of toys. We" +
                " use premium quality cat food so the furry baby can arrive with his / her vaccination" +
                " record book only.";

        String descriptionDaycare = "We can call our daycare an active daycare, because in our playground the cats" +
                " can play all day outside in the nature and they have enormous place for running. But when" +
                " we have rainy cold days they can play inside the heated house with confortable places, and" +
                " the inner closed playground.";

        PetUtility boarding = new PetUtility("boarding", descriptionBoarding, Currency.HUF, 5000);
        PetUtility daycare = new PetUtility("daycare", descriptionDaycare, Currency.HUF, 6000);

        petUtilityRepository.save(boarding);
        petUtilityRepository.save(daycare);

    }

}
