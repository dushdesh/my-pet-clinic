package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.Owner;
import com.dushdesh.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
        return super.save(owner);
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
