package curso.springframework.sfpetclinic.repositories;

import curso.springframework.sfpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
