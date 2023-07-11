package fmt.labmedication.api.enums;

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
}