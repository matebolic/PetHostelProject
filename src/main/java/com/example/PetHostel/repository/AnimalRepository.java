package com.example.PetHostel.repository;

import com.example.PetHostel.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByPetNameIgnoreCase(String petName);
    /* it should be modified:
    case: ther might exist more animal with the same petname: byPetNameAndPetOwnerUserName!
     */

    Animal findByPetName(String petName);

    @Query("SELECT a FROM Animal a JOIN PetOwner o WHERE CONCAT(o.lastName, ' ', o.firstName) = :fullName")
    List<Animal> findByTheOwnerFullName(@Param("fullName") String fullName);

}