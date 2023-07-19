package fmt.labmedication.api.entitites;

import java.time.LocalDateTime;

import fmt.labmedication.api.enums.MedicationTypeEnum;
import fmt.labmedication.api.enums.MedicationUnitEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "medications_administering")
@Getter
@Setter
public class MedicationAdministeringEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    LocalDateTime date;

    @Column(nullable = false)
    MedicationTypeEnum type;

    @Column(nullable = false)
    float amount;

    @Column(nullable = false)
    MedicationUnitEnum unit;

    @Column(nullable = false)
    String observations;

    @ManyToOne(optional = false)
    PatientEntity patient;

    @ManyToOne(optional = false)
    UserEntity doctor;
}