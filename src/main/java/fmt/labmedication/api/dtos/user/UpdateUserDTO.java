package fmt.labmedication.api.dtos.user;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import fmt.labmedication.api.enums.CivilStateEnum;
import fmt.labmedication.api.enums.SpecialtyEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDTO {
    Long id;

    @NotBlank
    String name;

    @NotBlank
    String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate birthdate;

    @NotBlank
    String cpf;

    @NotBlank
    String rg;

    @NotNull
    CivilStateEnum civilState;

    @NotBlank
    String telephone;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    String email;

    @NotBlank
    String nationality;

    @NotBlank
    String crm;

    @NotNull
    SpecialtyEnum specialty;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public UpdateUserDTO(String cpf, String telephone) {
        if (!cpf.matches("([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})"))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF precisa estar no formato: XXX.XXX.XXX-XX.");
        if (!telephone.matches("(\\([0-9]{2}\\)[0-9]{5}-[0-9]{4})|(\\([0-9]{2}\\)[0-9]{4}-[0-9]{4})"))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Telefone precisa estar em um dos formatos: (XX)XXXXX-XXXX | (XX)XXXX-XXXX.");
        this.cpf = cpf;
        this.telephone = telephone;
    }
}
