package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.Owner;
import com.dushdesh.mypetclinic.services.OwnerService;
import com.dushdesh.mypetclinic.services.PetService;
import com.dushdesh.mypetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    @Autowired
    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    Owner deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            owner.getPets().forEach(pet ->
            {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                       petTypeService.save(pet.getPetType());
                    }
                } else {
                    throw new RuntimeException("The pet type is required");
                }
                if (pet.getId() == null) {
                    petService.save(pet);
                }
            });
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public Owner delete(Owner owner) {
        return deleteById(owner.getId());
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
