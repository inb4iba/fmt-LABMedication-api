package fmt.labmedication.api.dtos.medicationAdministering;

import java.time.LocalDateTime;

import fmt.labmedication.api.entitites.PatientEntity;
import fmt.labmedication.api.entitites.UserEntity;
import fmt.labmedication.api.enums.MedicationTypeEnum;
import fmt.labmedication.api.enums.MedicationUnitEnum;

public class ResponseMedicationAdministeringDTO {
    Long id;

    String name;

    LocalDateTime date;

    MedicationTypeEnum type;

    float amount;

    MedicationUnitEnum unit;

    String observations;

    PatientEntity patient;

    UserEntity doctor;
}
