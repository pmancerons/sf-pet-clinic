package curso.springframework.sfpetclinic.services.jpadata;

import curso.springframework.sfpetclinic.model.Specialty;
import curso.springframework.sfpetclinic.repositories.SpecialtyRepository;
import curso.springframework.sfpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("datajpa")
public class SpecialtyJPADataService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyJPADataService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();

        specialtyRepository.findAll().forEach(specialties::add);

        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Override
    public void deleteById(Long id) {
    specialtyRepository.deleteById(id);
    }
}
