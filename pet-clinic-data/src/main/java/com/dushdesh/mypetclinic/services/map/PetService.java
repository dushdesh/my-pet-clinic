package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.Pet;
import com.dushdesh.mypetclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    Pet save(Long id, Pet object) {
        return super.save(id, object);
    }

    @Override
    Pet deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return null;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return save(pet.getId(), pet);
    }

    @Override
    public Pet delete(Pet pet) {
        return deleteById(pet.getId());
    }
}
