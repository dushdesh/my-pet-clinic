package com.dushdesh.mypetclinic.services.springDataJPA;

import com.dushdesh.mypetclinic.models.Owner;
import com.dushdesh.mypetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    String lastName = "Desh";
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(2L).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        assertEquals(lastName, service.findByLastName(lastName).getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(returnOwner);
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
        assertEquals(2, service.findAll().size());
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);
        assertNotNull(owner);

        Owner owner2 = service.findById(2L);
        assertNull(owner2);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }
}