package fmt.labmedication.api.dtos.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import fmt.labmedication.api.enums.CivilStateEnum;
import fmt.labmedication.api.enums.SpecialtyEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUserDTO {
    Long id;

    @JsonProperty("nome")
    String name;

    @JsonProperty("genero")
    String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("data_de_nascimento")
    LocalDate birthdate;

    String cpf;

    String rg;

    @JsonProperty("estado_civil")
    CivilStateEnum civilState;

    @JsonProperty("telefone")
    String telephone;

    String email;

    @JsonProperty("naturalidade")
    String nationality;

    String crm;

    @JsonProperty("especialidade_clinica")
    SpecialtyEnum specialty;
}
