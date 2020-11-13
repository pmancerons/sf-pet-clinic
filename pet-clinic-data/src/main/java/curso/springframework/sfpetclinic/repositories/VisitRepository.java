package curso.springframework.sfpetclinic.repositories;

import curso.springframework.sfpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
