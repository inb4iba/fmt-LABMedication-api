package fmt.labmedication.api.entitites;

import java.util.Date;

import fmt.labmedication.api.enums.MedicationTypeEnum;
import fmt.labmedication.api.enums.MedicationUnitEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "medications_administering")
@Getter
@Setter
@AllArgsConstructor
public class MedicationAdministeringEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Date date;

    @Column(nullable = false)
    MedicationTypeEnum type;

    @Column(nullable = false)
    float amount;

    @Column(nullable = false)
    MedicationUnitEnum unit;

    @Column(nullable = false)
    String observations;

    @OneToOne(optional = false)
    PatientEntity patient;

    @OneToOne(optional = false)
    UserEntity doctor;
}