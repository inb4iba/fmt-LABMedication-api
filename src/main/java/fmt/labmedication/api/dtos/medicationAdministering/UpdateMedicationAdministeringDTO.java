package fmt.labmedication.api.dtos.medicationAdministering;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime date;

    @NotNull
    Float amount;

    @NotNull
    MedicationUnitEnum unit;

    @NotBlank
    String observations;
}
