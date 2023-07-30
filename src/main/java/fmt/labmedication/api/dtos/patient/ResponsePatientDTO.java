package fmt.labmedication.api.dtos.patient;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import fmt.labmedication.api.entitites.AddressEntity;
import fmt.labmedication.api.enums.CivilStateEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePatientDTO {
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

    @JsonProperty("contato_de_emergencia")
    String emergencyContact;

    @JsonProperty("alergias")
    String allergiesList;

    @JsonProperty("cuidados_especificos")
    String specialCaresList;

    @JsonProperty("convenio")
    String healthplan;

    @JsonProperty("numero_carteira_convenio")
    String healthplanNumber;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("validade_convenio")
    LocalDate healthplanExpireDate;

    @JsonProperty("endereco")
    AddressEntity address;
}
