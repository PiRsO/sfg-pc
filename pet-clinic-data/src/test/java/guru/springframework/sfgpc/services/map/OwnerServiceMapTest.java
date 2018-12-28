package guru.springframework.sfgpc.services.map;

import guru.springframework.sfgpc.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals(Long.valueOf(1L), owner.getId());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(2L).build();

        Owner ownerSaved1 = ownerServiceMap.save(owner);
        Owner ownerSavedFromRepo = ownerServiceMap.findById(2L);
        assertEquals(owner, ownerSaved1);
        assertEquals(owner, ownerSavedFromRepo);
    }

    @Test
    void delete() {
        Owner toDelete = Owner.builder().id(1L).build();

        ownerServiceMap.delete(toDelete);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deletedById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        final String lastName = "LastName";
        Owner ownerWithLastName = Owner.builder().id(2L).lastName(lastName).build();
        ownerServiceMap.save(ownerWithLastName);
        assertEquals(ownerWithLastName, ownerServiceMap.findByLastName(lastName));
    }
}
