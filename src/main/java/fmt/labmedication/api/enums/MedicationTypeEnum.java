package fmt.labmedication.api.enums;

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
}