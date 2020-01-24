package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.Vet;
import com.dushdesh.mypetclinic.services.CrudService;
import com.dushdesh.mypetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    Vet save(Long aLong, Vet object) {
        return super.save(aLong, object);
    }

    @Override
    Vet deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return save(vet.getId(), vet);
    }

    @Override
    public Vet delete(Vet vet) {
        return deleteById(vet.getId());
    }
}
