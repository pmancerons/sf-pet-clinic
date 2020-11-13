package curso.springframework.sfpetclinic.repositories;

import curso.springframework.sfpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
