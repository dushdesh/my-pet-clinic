package com.dushdesh.mypetclinic.services.springDataJPA;

import com.dushdesh.mypetclinic.models.Pet;
import com.dushdesh.mypetclinic.repositories.PetRepository;
import com.dushdesh.mypetclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet delete(Pet pet) {
        petRepository.delete(pet);
        return pet;
    }
}
