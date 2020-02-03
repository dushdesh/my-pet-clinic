package com.dushdesh.mypetclinic.bootstrap;

import com.dushdesh.mypetclinic.models.Owner;
import com.dushdesh.mypetclinic.models.PetType;
import com.dushdesh.mypetclinic.models.Vet;
import com.dushdesh.mypetclinic.services.OwnerService;
import com.dushdesh.mypetclinic.services.PetTypeService;
import com.dushdesh.mypetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType pig = new PetType();
        pig.setName("Pig");
        PetType savedPigPetType = petTypeService.save(pig);

        Owner owner1 = new Owner();
        owner1.setFirstName("Rakesh");
        owner1.setLastName("Roshan");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Hrithik");
        owner2.setLastName("Roshan");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("David");
        vet1.setLastName("Dhavan");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Varun");
        vet2.setLastName("Dhavan");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
