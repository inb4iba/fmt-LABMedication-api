package fmt.labmedication.api.entitites;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "patients")
@Getter
@Setter
@AllArgsConstructor
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

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    AddressEntity address;

}
