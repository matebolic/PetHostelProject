package com.example.PetHostel.repository;

import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.modelFromEnum.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

    public List<PetOwner> findByMembership(Membership membership);


}
