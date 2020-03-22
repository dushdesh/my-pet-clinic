package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    private OwnerMapService ownerMapService;
    final private Long ownerId = 1L;
    final private String lastName = "Desh";
    Owner owner;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        owner = ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findById() {
        Owner foundOwner = ownerMapService.findById(ownerId);
        assertEquals(foundOwner.getId(), ownerId);
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(ownerMapService.findAll().size(), 0);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(owners.size(), 1);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner savedOwner = ownerMapService.save(Owner.builder().id(id).build());
        assertEquals(savedOwner.getId(), id);
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(owner);
        assertEquals(ownerMapService.findAll().size(), 0);
    }

    @Test
    void findByLastName() {
        Owner foundOwner = ownerMapService.findByLastName(lastName);
        assertNotNull(foundOwner);
        assertEquals(foundOwner.getLastName(), lastName);
    }

    @Test
    void findByLastNameNotFound() {
        Owner notFoundOwner = ownerMapService.findByLastName("foo");
        assertNull(notFoundOwner);
    }
}