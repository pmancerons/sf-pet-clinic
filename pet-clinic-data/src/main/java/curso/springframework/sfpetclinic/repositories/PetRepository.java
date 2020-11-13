package curso.springframework.sfpetclinic.repositories;

import curso.springframework.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
