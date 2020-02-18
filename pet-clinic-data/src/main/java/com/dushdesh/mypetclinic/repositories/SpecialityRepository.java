package com.dushdesh.mypetclinic.repositories;

import com.dushdesh.mypetclinic.models.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
