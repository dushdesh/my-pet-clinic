package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.Vet;
import com.dushdesh.mypetclinic.services.SpecialityService;
import com.dushdesh.mypetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    @Autowired
    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
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
        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    speciality.setId(specialityService.save(speciality).getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet delete(Vet vet) {
        return deleteById(vet.getId());
    }
}
