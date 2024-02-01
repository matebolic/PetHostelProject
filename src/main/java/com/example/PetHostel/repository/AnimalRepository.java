package com.example.PetHostel.repository;

import com.example.PetHostel.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByOwnerId(Long id);

    //original native psql solution
//    @Query(nativeQuery = true, value = "SELECT a.*, a.id as pet_id FROM animal a INNER JOIN pet_owner o ON a.owner_id = o.id WHERE last_name || ' ' || first_name = ?1")
//    List<Animal> findByTheOwnersFullName(String fullName);

    //JPQL query
    @Query("SELECT a FROM Animal a JOIN PetOwner o ON a.ownerId = o.id WHERE CONCAT(o.lastName, ' ', o.firstName) = :fullName")
    List<Animal> findByTheOwnersFullName(@Param("fullName") String fullName);


//find by reservation's date -list

//find by petName -list


}