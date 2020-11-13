package curso.springframework.sfpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {

    private String description;

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + getId() + '\'' +
                "description='" + description + '\'' +
                '}';
    }
}
