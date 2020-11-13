package curso.springframework.sfpetclinic.services.jpadata;

import curso.springframework.sfpetclinic.model.Visit;
import curso.springframework.sfpetclinic.repositories.VisitRepository;
import curso.springframework.sfpetclinic.services.PetService;
import curso.springframework.sfpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("datajpa")
public class VisitJPADataService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitJPADataService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();

        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
