package fmt.labmedication.api.dtos.user;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonCreator;
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

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RegisterUserDTO(String cpf, String telephone) {
        if (!cpf.matches("([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})"))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF precisa estar no formato: XXX.XXX.XXX-XX.");
        if (!telephone.matches("(\\([0-9]{2}\\)[0-9]{5}-[0-9]{4})|(\\([0-9]{2}\\)[0-9]{4}-[0-9]{4})"))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Telefone precisa estar em um dos formatos: (XX)XXXXX-XXXX | (XX)XXXX-XXXX.");
        this.cpf = cpf;
        this.telephone = telephone;
    }
}