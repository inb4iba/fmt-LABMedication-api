package fmt.labmedication.api.dtos.user;

import java.time.LocalDate;

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
public class RegisterUserDTO {
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

    @NotBlank
    String password;
}
