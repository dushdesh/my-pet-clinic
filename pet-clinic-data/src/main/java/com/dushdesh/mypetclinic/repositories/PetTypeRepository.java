package com.dushdesh.mypetclinic.repositories;

import com.dushdesh.mypetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
