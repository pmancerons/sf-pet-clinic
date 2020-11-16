package curso.springframework.sfpetclinic.services.jpadata;

import curso.springframework.sfpetclinic.model.Owner;
import curso.springframework.sfpetclinic.repositories.OwnerRepository;
import curso.springframework.sfpetclinic.repositories.PetRepository;
import curso.springframework.sfpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PetJPADataServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJPADataService ownerJPADataService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName(){
        Owner returnOwner = Owner.builder().id(1l).lastName("Ceron").build();

        when(ownerRepository.findByLastName(eq("Ceron"))).thenReturn(returnOwner);

        assertEquals(1l,ownerJPADataService.findByLastName("Ceron").getId());

    }

    @Test
    void findAll() {
        Set<Owner> ownersReturn = new HashSet<>();
        Owner owner1 = Owner.builder().id(1l).lastName("Ceron").build();
        Owner owner2 = Owner.builder().id(2l).lastName("Ceron2").build();

        ownersReturn.add(owner1);
        ownersReturn.add(owner2);

        when(ownerRepository.findAll()).thenReturn(ownersReturn);
        Set<Owner> ownersFound = ownerJPADataService.findAll();

        assertEquals(2,ownersFound.size());
    }

    @Test
    void findById() {
        Owner returnOwner = Owner.builder().id(1l).lastName("Ceron").build();

        when(ownerRepository.findById(eq(1l))).thenReturn(Optional.of(returnOwner));

        assertEquals("Ceron",ownerJPADataService.findById(1l).getLastName());

    }


    @Test
    void findByIdDoesNotExist() {

        when(ownerRepository.findById(eq(1l))).thenReturn(Optional.empty());

        assertNull(ownerJPADataService.findById(1l));

    }

    @Test
    void save() {
        Owner returnOwner = Owner.builder().id(1l).lastName("Ceron").build();

        when(ownerRepository.save(returnOwner)).thenReturn(returnOwner);

        assertEquals(returnOwner,ownerJPADataService.save(returnOwner));
    }

    @Test
    void delete() {
        Owner returnOwner = Owner.builder().id(1l).lastName("Ceron").build();

        ownerJPADataService.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJPADataService.deleteById(1l);

        verify(ownerRepository).deleteById(any());
    }
}