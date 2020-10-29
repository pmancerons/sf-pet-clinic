package curso.springframework.sfpetclinic.bootstrap;

import curso.springframework.sfpetclinic.model.Owner;
import curso.springframework.sfpetclinic.model.Pet;
import curso.springframework.sfpetclinic.model.PetType;
import curso.springframework.sfpetclinic.model.Vet;
import curso.springframework.sfpetclinic.services.OwnerService;
import curso.springframework.sfpetclinic.services.PetService;
import curso.springframework.sfpetclinic.services.PetTypeService;
import curso.springframework.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setPetName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setPetName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        PetType bird = new PetType();
        dog.setPetName("Bird");

        PetType savedBirdPetType = petTypeService.save(bird);

        Owner owner1 = new Owner();
        owner1.setFirstName("Pedro");
        owner1.setLastName("Ceron");
        owner1.setAddress("fake 123");
        owner1.setCity("Bogota");
        owner1.setTelephone("123456");

        Pet pedrosDog = new Pet();
        pedrosDog.setName("Machine");
        pedrosDog.setPetType(savedDogPetType);
        pedrosDog.setOwner(owner1);
        pedrosDog.setBirthDate(LocalDate.now());

        owner1.getPets().add(pedrosDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Maria");
        owner2.setLastName("Serrato");
        owner2.setAddress("fake 321");
        owner2.setCity("Bogota");
        owner2.setTelephone("654321");

        Pet mariasCat = new Pet();
        mariasCat.setName("Mini");
        mariasCat.setPetType(savedCatPetType);
        mariasCat.setOwner(owner2);
        mariasCat.setBirthDate(LocalDate.now());

        owner2.getPets().add(mariasCat);

        ownerService.save(owner2);

        System.out.println("owners created");

        Vet vet1 = new Vet();
        vet1.setFirstName("vete");
        vet1.setLastName("1");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vete");
        vet2.setLastName("2");

        vetService.save(vet2);

        System.out.println("vet created");
    }
}
