package fmt.labmedication.api.dtos.user;

import java.time.LocalDate;

import fmt.labmedication.api.enums.CivilStateEnum;
import fmt.labmedication.api.enums.SpecialtyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseUserDTO {
    Long id;

    String name;

    String gender;

    LocalDate birthdate;

    String cpf;

    String rg;

    CivilStateEnum civil_state;

    String telephone;

    String email;

    String nationality;

    String crm;

    SpecialtyEnum specialty;
}
