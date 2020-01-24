package com.dushdesh.mypetclinic.services;

import com.dushdesh.mypetclinic.models.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long Id);
    Owner findByLastName(String lastName);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
