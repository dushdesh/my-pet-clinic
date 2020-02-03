package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.PetType;
import com.dushdesh.mypetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public PetType delete(PetType petType) {
        return super.deleteById(petType.getId());
    }


}
