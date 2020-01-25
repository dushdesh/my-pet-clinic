package com.dushdesh.mypetclinic.bootstrap;

import com.dushdesh.mypetclinic.models.Owner;
import com.dushdesh.mypetclinic.models.Vet;
import com.dushdesh.mypetclinic.services.OwnerService;
import com.dushdesh.mypetclinic.services.VetService;
import com.dushdesh.mypetclinic.services.map.OwnerServiceMap;
import com.dushdesh.mypetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Rakesh");
        owner1.setLastName("Roshan");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Hrithik");
        owner2.setLastName("Roshan");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("David");
        vet1.setLastName("Dhavan");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Varun");
        vet2.setLastName("Dhavan");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
