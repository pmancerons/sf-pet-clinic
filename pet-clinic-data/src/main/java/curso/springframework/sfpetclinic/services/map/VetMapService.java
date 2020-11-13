package curso.springframework.sfpetclinic.services.map;

import curso.springframework.sfpetclinic.model.Specialty;
import curso.springframework.sfpetclinic.model.Vet;
import curso.springframework.sfpetclinic.services.CrudService;
import curso.springframework.sfpetclinic.services.SpecialtyService;
import curso.springframework.sfpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet.getSpecialties().size() > 0){
            vet.getSpecialties().forEach( specialty -> {
                if(specialty != null){
                    if(specialty.getId() == null){
                        Specialty savedSpecialty = specialtyService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                }else{
                    throw new RuntimeException("specialty in vet can not be null");
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
