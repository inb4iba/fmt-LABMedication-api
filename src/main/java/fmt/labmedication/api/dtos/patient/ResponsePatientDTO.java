package fmt.labmedication.api.dtos.patient;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import fmt.labmedication.api.entitites.AddressEntity;
import fmt.labmedication.api.enums.CivilStateEnum;

public class ResponsePatientDTO {
    Long id;

    String name;

    String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate birthdate;

    String cpf;

    String rg;

    CivilStateEnum civilState;

    String telephone;

    String email;

    String nationality;

    String emergencyContact;

    String allergiesList;

    String specialCaresList;

    String healthplan;

    String healthplanNumber;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate healthplanExpireDate;

    AddressEntity address;
}
