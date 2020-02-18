package com.dushdesh.mypetclinic.repositories;

import com.dushdesh.mypetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
