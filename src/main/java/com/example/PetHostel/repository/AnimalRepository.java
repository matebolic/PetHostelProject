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

    @Query("SELECT a FROM Animal a WHERE a.pet_owner_id = :ownerId")
    List<Animal> findByOwnerId(@Param("ownerId") Long id);

    @Query("SELECT a FROM Animal a JOIN PetOwner o WHERE CONCAT(o.lastName, ' ', o.firstName) = :fullName")
    List<Animal> findByTheOwnerFullName(@Param("fullName") String fullName);

//    @Modifying
//    @Query("UPDATE Animal a SET a.name = :nameAnimal WHERE a.id = :idAnimal")
//    void updateName(@Param("nameAnimal") String name, @Param("idAnimal") Long id);


}