package fmt.labmedication.api.dtos.medicationAdministering;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("nome")
    String name;

    @JsonProperty("data_administracao")
    LocalDateTime date;

    @NotNull
    @JsonProperty("tipo_medicamento")
    MedicationTypeEnum type;

    @NotNull
    @JsonProperty("quantidade")
    Float amount;

    @NotNull
    @JsonProperty("unidade_medicamento")
    MedicationUnitEnum unit;

    @NotBlank
    @JsonProperty("observacoes")
    String observations;

    @NotNull
    @JsonProperty("paciente_id")
    PatientEntity patient;

    @NotNull
    @JsonProperty("medico_id")
    UserEntity doctor;

    public RegisterMedicationAdministeringDTO() {
        date = LocalDateTime.now();
    }
}
