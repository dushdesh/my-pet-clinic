package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.Pet;
import com.dushdesh.mypetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

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
        return super.save(pet);
    }

    @Override
    public Pet delete(Pet pet) {
        return deleteById(pet.getId());
    }
}
