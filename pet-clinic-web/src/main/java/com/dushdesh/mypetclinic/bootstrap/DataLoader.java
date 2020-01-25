package com.dushdesh.mypetclinic.bootstrap;

import com.dushdesh.mypetclinic.models.Owner;
import com.dushdesh.mypetclinic.models.Vet;
import com.dushdesh.mypetclinic.services.OwnerService;
import com.dushdesh.mypetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
