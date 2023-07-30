package fmt.labmedication.api.enums;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonCreator;

import fmt.labmedication.api.utils.GenerateErrorMessage;
import lombok.Getter;

@Getter
public enum MedicationUnitEnum {
    MILIGRAMA("mg"),
    MICROGRAMA("mcg"),
    GRAMA("g"),
    MILILITRO("mL"),
    PORCENTAGEM("%");

    private String unit;

    private MedicationUnitEnum(String unit) {
        this.unit = unit;
    }

    @JsonCreator
    public static MedicationUnitEnum parseJsonToEnum(String value) {
        try {
            return MedicationUnitEnum.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    GenerateErrorMessage.enumError("Envie uma unidade de medida válida: ", MedicationUnitEnum.class));
        }
    }
}