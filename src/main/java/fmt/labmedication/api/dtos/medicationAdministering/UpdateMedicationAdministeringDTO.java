package fmt.labmedication.api.dtos.medicationAdministering;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("tipo_medicamento")
    MedicationTypeEnum type;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @JsonProperty("data_administracao")
    LocalDateTime date;

    @NotNull
    @JsonProperty("quantidade")
    Float amount;

    @NotNull
    @JsonProperty("unidade_medicamento")
    MedicationUnitEnum unit;

    @NotBlank
    @JsonProperty("observacoes")
    String observations;
}
