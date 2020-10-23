package curso.springframework.sfpetclinic.services;

import curso.springframework.sfpetclinic.model.Owner;
import curso.springframework.sfpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
