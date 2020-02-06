package com.dushdesh.mypetclinic.bootstrap;

import com.dushdesh.mypetclinic.models.*;
import com.dushdesh.mypetclinic.services.OwnerService;
import com.dushdesh.mypetclinic.services.PetTypeService;
import com.dushdesh.mypetclinic.services.SpecialityService;
import com.dushdesh.mypetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
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
        owner1.setAddress("123 Dallas Dr");
        owner1.setCity("Houston");
        owner1.setTelephone("1234554321");

        Pet owner1Pet = new Pet();
        owner1Pet.setOwner(owner1);
        owner1Pet.setName("Zizou");
        owner1Pet.setBirthDate(LocalDate.of(2012, 6, 14));
        owner1Pet.setPetType(savedDogPetType);
        owner1.getPets().add(owner1Pet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Hrithik");
        owner2.setLastName("Roshan");
        owner1.setAddress("123 Houston Dr");
        owner1.setCity("Dallas");
        owner1.setTelephone("1234567890");

        Pet owner2Pet = new Pet();
        owner2Pet.setOwner(owner2);
        owner2Pet.setName("Luna");
        owner2Pet.setBirthDate(LocalDate.of(2014, 4, 27));
        owner2Pet.setPetType(savedCatPetType);
        owner2.getPets().add(owner2Pet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSuregery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("David");
        vet1.setLastName("Dhavan");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Varun");
        vet2.setLastName("Dhavan");
        vet2.getSpecialities().add(savedSuregery);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
