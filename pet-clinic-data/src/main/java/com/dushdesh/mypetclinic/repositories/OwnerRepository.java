package com.dushdesh.mypetclinic.repositories;

import com.dushdesh.mypetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
