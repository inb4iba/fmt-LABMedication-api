package fmt.labmedication.api.enums;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonCreator;

import fmt.labmedication.api.utils.GenerateErrorMessage;
import lombok.Getter;

@Getter
public enum SpecialtyEnum {
    CLINICO_GERAL("Clínico Geral"),
    ANESTESISTA("Anestesista"),
    DERMATOLOGIA("Dermatologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    PSIQUIATRIA("Psiquiatria"),
    ORTOPEDIA("Ortopedia");

    private String specialty;

    private SpecialtyEnum(String specialty) {
        this.specialty = specialty;
    }

    @JsonCreator
    public static SpecialtyEnum parseJsonToEnum(String value) {
        try {
            return SpecialtyEnum.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    GenerateErrorMessage.enumError("Envie uma especialização válida: ", SpecialtyEnum.class));
        }
    }
}
