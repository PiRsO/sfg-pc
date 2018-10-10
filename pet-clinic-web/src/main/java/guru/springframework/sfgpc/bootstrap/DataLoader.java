package guru.springframework.sfgpc.bootstrap;

import guru.springframework.sfgpc.model.Owner;
import guru.springframework.sfgpc.model.Pet;
import guru.springframework.sfgpc.model.PetType;
import guru.springframework.sfgpc.model.Vet;
import guru.springframework.sfgpc.services.OwnerService;
import guru.springframework.sfgpc.services.VetService;
import guru.springframework.sfgpc.services.map.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    /**
     * will be run  during startup
     * @param args
     * @throws Exception
     */
    @Override
    public void run(final String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("5555551115");

        Pet mikePet = new Pet();
        mikePet.setPetType(savedDogPetType);
        mikePet.setOwner(owner1);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Rosco");
        owner1.getPets().add(mikePet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("5555551115");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setOwner(owner2);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
