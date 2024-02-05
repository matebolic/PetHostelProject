package com.example.PetHostel.repository;

import com.example.PetHostel.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

//    @Query("SELECT a FROM Animal a WHERE a.pet_owner_id = :ownerId")
    @Query(nativeQuery = true, value = "SELECT * FROM animal where pet_owner_id = ?1")
    List<Animal> findByOwnerId(Long id);

    //original native psql solution
//    @Query(nativeQuery = true, value = "SELECT a.*, a.id as pet_id FROM animal a INNER JOIN pet_owner o ON a.owner_id = o.id WHERE last_name || ' ' || first_name = ?1")
//    List<Animal> findByTheOwnersFullName(String fullName);

    //JPQL query
    @Query("SELECT a FROM Animal a JOIN PetOwner o WHERE CONCAT(o.lastName, ' ', o.firstName) = :fullName")
    List<Animal> findByTheOwnerFullName(@Param("fullName") String fullName);

    List<Animal> findByPetNameIgnoreCase(String petName);

    @Query(nativeQuery = true, value = """
            SELECT a.*, r.starting_date, r.finishing_date
            FROM animal a 
            INNER JOIN reservation r ON a.id = r.animal_id
            WHERE now() BETWEEN r.starting_date AND r.finishing_date;
            """)
    List<Animal> findNow();


    @Query("SELECT a FROM Animal a JOIN a.reservationOfAnimal r WHERE :searchedDate BETWEEN r.startingDate And r.finishingDate")
    List<Animal> findByDates(@Param("searchedDate") LocalDate localDate);
    //ON a.id = r.animal_id was taken out

    //--------------------need to modify-----------------------------------------------------------//
//alternative to the method below
//    @Modifying
//    @Query("UPDATE Animal a SET a.name = :nameAnimal WHERE a.id = :idAnimal")
//    void updateName(@Param("nameAnimal") String name, @Param("idAnimal") Long id);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Animal a SET a.name = ?1 WHERE a.id = ?2")
    void updateName(String name, Long id);

    //--------------------need to modify-----------------------------------------------------------//

}