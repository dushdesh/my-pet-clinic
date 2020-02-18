package com.dushdesh.mypetclinic.repositories;

import com.dushdesh.mypetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
