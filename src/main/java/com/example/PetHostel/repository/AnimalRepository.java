package com.example.PetHostel.repository;

import com.example.PetHostel.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

//    @Query("SELECT a FROM Animal a WHERE a.pet_owner_id = :ownerId")
    @Query(nativeQuery = true, value = "SELECT * FROM animal where pet_owner_id = ?1")
    List<Animal> findByOwnerId(Long id);

    @Query("SELECT a FROM Animal a JOIN PetOwner o WHERE CONCAT(o.lastName, ' ', o.firstName) = :fullName")
    List<Animal> findByTheOwnerFullName(@Param("fullName") String fullName);

    List<Animal> findByPetNameIgnoreCase(String petName);

    @Query(nativeQuery = true, value = """
            SELECT a.*, r.starting_date, r.finishing_date
            FROM animal a 
            INNER JOIN reservation r ON a.id = r.animal_id
            WHERE now() BETWEEN r.starting_date AND r.finishing_date;
            """)

    List<Animal> findActual();


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