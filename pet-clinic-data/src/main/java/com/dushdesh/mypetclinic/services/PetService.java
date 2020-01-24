package com.dushdesh.mypetclinic.services;

import com.dushdesh.mypetclinic.models.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long Id);
    Pet save (Pet pet);
    Set<Pet> findAll();
}
