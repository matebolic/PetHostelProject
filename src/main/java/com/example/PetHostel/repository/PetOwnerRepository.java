package com.example.PetHostel.repository;

import com.example.PetHostel.model.Animal;
import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.modelFromEnum.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

    PetOwner findByUserName(String username);

    @Query("SELECT o FROM PetOwner o WHERE CONCAT(o.lastName, ' ', o.firstName) = :fullName")
    public List<PetOwner> findByFullName(String fullName);


}
