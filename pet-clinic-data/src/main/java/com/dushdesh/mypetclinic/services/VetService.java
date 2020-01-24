package com.dushdesh.mypetclinic.services;

import com.dushdesh.mypetclinic.models.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long Id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
