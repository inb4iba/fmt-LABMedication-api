package fmt.labmedication.api.entitites;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "patients")
@Getter
@Setter
public class PatientEntity extends PersonEntity {
    @Column(nullable = false)
    String emergencyContact;

    @Column(nullable = true)
    String allergiesList;

    @Column(nullable = true)
    String specialCaresList;

    @Column(nullable = true)
    String healthplan;

    @Column(nullable = true)
    String healthplanNumber;

    @Column(nullable = true)
    LocalDate healthplanExpireDate;

    @OneToOne(optional = false)
    AddressEntity address;

}
