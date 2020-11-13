package curso.springframework.sfpetclinic.repositories;

import curso.springframework.sfpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
