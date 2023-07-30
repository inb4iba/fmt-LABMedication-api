package fmt.labmedication.api.dtos.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import fmt.labmedication.api.enums.CivilStateEnum;
import fmt.labmedication.api.enums.SpecialtyEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {
    @NotBlank
    @JsonProperty("nome")
    String name;

    @NotBlank
    @JsonProperty("genero")
    String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("data_de_nascimento")
    LocalDate birthdate;

    @NotBlank
    String cpf;

    @NotBlank
    String rg;

    @NotNull
    @JsonProperty("estado_civil")
    CivilStateEnum civilState;

    @NotBlank
    @JsonProperty("telefone")
    String telephone;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    String email;

    @NotBlank
    @JsonProperty("naturalidade")
    String nationality;

    @NotBlank
    String crm;

    @NotNull
    @JsonProperty("especialidade_clinica")
    SpecialtyEnum specialty;

    @NotBlank
    @Size(min = 8)
    @JsonProperty("senha")
    String password;
}
