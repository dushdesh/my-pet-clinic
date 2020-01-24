package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.Owner;
import com.dushdesh.mypetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long> {

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    Owner save(Long id, Owner owner) {
        return super.save(id, owner);
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
        return save(owner.getId(), owner);
    }

    @Override
    public Owner delete(Owner owner) {
        return deleteById(owner.getId());
    }
}
