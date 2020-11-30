package curso.springframework.sfpetclinic.services.map;

import curso.springframework.sfpetclinic.model.Owner;
import curso.springframework.sfpetclinic.model.Pet;
import curso.springframework.sfpetclinic.services.OwnerService;
import curso.springframework.sfpetclinic.services.PetService;
import curso.springframework.sfpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        Owner savedOwner = null;
        if(owner != null){
            owner.getPets().forEach( pet-> {
                if(pet.getPetType() != null){
                    if(pet.getPetType().getId() == null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                }else{
                    throw new RuntimeException("Pet type is required");
                }

                if(pet == null){
                    throw new RuntimeException("Pet can not be null");
                }else {
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                }
            });
        }
        return super.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> owners  = this.findAll();
        return owners.stream().filter( o -> o.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        Set<Owner> owners  = this.findAll();
        return owners.stream().filter( o -> o.getLastName().contains(lastName))
                .collect(Collectors.toList());
    }
}
