package com.example.PetHostel.service;

import com.example.PetHostel.model.PetOwner;
import com.example.PetHostel.modelFromEnum.Membership;
import com.example.PetHostel.repository.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

@Service
public class PetOwnerService {

    @Autowired
    PetOwnerRepository petOwnerRepository;

    //-------------------------------------------------------------------------------//

    public PetOwner save(PetOwner petOwner) {
        return petOwnerRepository.save(petOwner);
    }


    //-------------------------------------------------------------------------------//

    public List<PetOwner> findAll() {
        return petOwnerRepository.findAll();
    }

    public List<PetOwner> findByMembership(Membership membership) {
        return petOwnerRepository.findByMembership(membership);
    }

    //-------------------------------------------------------------------------------//

    public PetOwner update(PetOwner petOwner) {
        return petOwnerRepository.save(petOwner);
    }

    //-------------------------------------------------------------------------------//

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        petOwnerRepository.deleteById(id);
    }


}
