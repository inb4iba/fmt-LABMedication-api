package fmt.labmedication.api.dtos.medicationAdministering;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import fmt.labmedication.api.enums.MedicationTypeEnum;
import fmt.labmedication.api.enums.MedicationUnitEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMedicationAdministeringDTO {
    Long id;

    @JsonProperty("nome")
    String name;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("data_administracao")
    LocalDateTime date;

    @JsonProperty("tipo_medicamento")
    MedicationTypeEnum type;

    @JsonProperty("quantidade")
    float amount;

    @JsonProperty("unidade_medicamento")
    MedicationUnitEnum unit;

    @JsonProperty("observacoes")
    String observations;

    @JsonProperty("paciente_id")
    Long patientId;

    @JsonProperty("medico_id")
    Long doctorId;
}
