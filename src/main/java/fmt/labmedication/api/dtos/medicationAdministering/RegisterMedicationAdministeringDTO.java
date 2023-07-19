package fmt.labmedication.api.dtos.medicationAdministering;

import java.time.LocalDateTime;

import fmt.labmedication.api.entitites.PatientEntity;
import fmt.labmedication.api.entitites.UserEntity;
import fmt.labmedication.api.enums.MedicationTypeEnum;
import fmt.labmedication.api.enums.MedicationUnitEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterMedicationAdministeringDTO {
    @NotBlank
    String name;

    LocalDateTime date;

    @NotNull
    MedicationTypeEnum type;

    @NotNull
    Float amount;

    @NotNull
    MedicationUnitEnum unit;

    @NotBlank
    String observations;

    @NotNull
    PatientEntity patient;

    @NotNull
    UserEntity doctor;

    public RegisterMedicationAdministeringDTO() {
        date = LocalDateTime.now();
    }
}
