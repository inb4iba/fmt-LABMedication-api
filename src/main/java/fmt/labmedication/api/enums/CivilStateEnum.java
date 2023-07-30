package fmt.labmedication.api.enums;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonCreator;

import fmt.labmedication.api.utils.GenerateErrorMessage;
import lombok.Getter;

@Getter
public enum CivilStateEnum {
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    SEPARADO("Separado"),
    DIVORCIADO("Divorciado"),
    VIUVO("Vi\u00FAvo");

    private String state;

    private CivilStateEnum(String state) {
        this.state = state;
    }

    @JsonCreator
    public static CivilStateEnum parseJsonToEnum(String value) {
        try {
            return CivilStateEnum.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    GenerateErrorMessage.enumError("Envie um estado civil válido: ", CivilStateEnum.class));
        }
    }
}