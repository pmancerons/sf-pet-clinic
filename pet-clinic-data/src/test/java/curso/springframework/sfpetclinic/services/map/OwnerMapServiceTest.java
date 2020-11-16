package curso.springframework.sfpetclinic.services.map;

import curso.springframework.sfpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());

        ownerMapService.save(Owner.builder().id(1l)
                .firstName("data").lastName("for test").build());

        ownerMapService.save(Owner.builder().id(2l)
                .firstName("data2").lastName("for test2").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(2,owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(2l);

        assertEquals("data2",owner.getFirstName());
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().firstName("Pedro")
                .lastName("C").city("B").address("C")
                .telephone("031").build();

        Owner savedOwner = ownerMapService.save(ownerToSave);

        assertNotNull(savedOwner.getId());
        assertEquals("Pedro",savedOwner.getFirstName());
    }

    @Test
    void delete() {
        Owner owner = ownerMapService.findById(2l);
        ownerMapService.delete(owner);
        assertEquals(1,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(2l);
        assertEquals(1,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName("for test2");

        assertEquals(2,owner.getId());
    }


    @Test
    void findByLastNameDoesNotExists() {
        Owner owner = ownerMapService.findByLastName("not exist");

        assertNull(owner);
    }
}