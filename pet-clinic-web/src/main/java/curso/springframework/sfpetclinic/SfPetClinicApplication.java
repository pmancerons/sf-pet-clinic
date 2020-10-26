package curso.springframework.sfpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SfPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfPetClinicApplication.class, args);
    }

}
