package com.dushdesh.mypetclinic.repositories;

import com.dushdesh.mypetclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
