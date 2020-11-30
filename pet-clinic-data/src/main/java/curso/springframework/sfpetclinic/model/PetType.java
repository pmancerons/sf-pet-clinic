package curso.springframework.sfpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity{

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.petTypeName = name;
    }

    @Column(name = "name")
    private String petTypeName;

    public String toString(){
        return petTypeName;
    }
}
