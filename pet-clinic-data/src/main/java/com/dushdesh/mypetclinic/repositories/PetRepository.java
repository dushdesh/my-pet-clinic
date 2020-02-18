package com.dushdesh.mypetclinic.repositories;

import com.dushdesh.mypetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
