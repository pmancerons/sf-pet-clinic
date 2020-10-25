package curso.springframework.sfpetclinic.services;

import curso.springframework.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}
