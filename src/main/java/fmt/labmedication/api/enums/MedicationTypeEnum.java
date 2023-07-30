package fmt.labmedication.api.enums;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonCreator;

import fmt.labmedication.api.utils.GenerateErrorMessage;
import lombok.Getter;

@Getter
public enum MedicationTypeEnum {
    CAPSULA("Cápsula"),
    COMPRIMIDO("Comprimido"),
    LIQUIDO("Líquido"),
    CREME("Creme"),
    GEL("Gel"),
    INALACAO("Inalação"),
    INJECAO("Injeção"),
    SPRAY("Spray");

    private String type;

    private MedicationTypeEnum(String type) {
        this.type = type;
    }

    @JsonCreator
    public static MedicationTypeEnum parseJsonToEnum(String value) {
        try {
            return MedicationTypeEnum.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    GenerateErrorMessage.enumError("Envie um tipo de medicamento válido: ", MedicationTypeEnum.class));
        }
    }
}