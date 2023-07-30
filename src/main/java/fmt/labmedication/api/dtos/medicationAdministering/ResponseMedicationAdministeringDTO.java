package fmt.labmedication.api.dtos.medicationAdministering;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import fmt.labmedication.api.enums.MedicationTypeEnum;
import fmt.labmedication.api.enums.MedicationUnitEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMedicationAdministeringDTO {
    Long id;

    String name;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime date;

    MedicationTypeEnum type;

    float amount;

    MedicationUnitEnum unit;

    String observations;

    Long patientId;

    Long doctorId;
}
