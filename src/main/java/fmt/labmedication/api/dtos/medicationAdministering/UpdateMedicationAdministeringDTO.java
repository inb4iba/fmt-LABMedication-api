package fmt.labmedication.api.dtos.medicationAdministering;

import fmt.labmedication.api.enums.MedicationTypeEnum;
import fmt.labmedication.api.enums.MedicationUnitEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMedicationAdministeringDTO {
    @NotNull
    MedicationTypeEnum type;

    @NotNull
    Float amount;

    @NotNull
    MedicationUnitEnum unit;

    @NotBlank
    String observations;
}
