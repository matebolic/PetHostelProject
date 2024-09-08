package com.example.PetHostel;

import com.example.PetHostel.function.DataInitializer;
import com.example.PetHostel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetHostelApplication {

    private final DataInitializer dataInitializer;

    @Autowired
    public PetHostelApplication(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
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

            dataInitializer.saveTestEntities();
            dataInitializer.savePetUtility();

            System.out.println("Successfully finished with CommandLineRunner.");
        };
    }
}


