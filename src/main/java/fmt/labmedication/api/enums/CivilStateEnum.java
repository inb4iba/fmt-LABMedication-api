package fmt.labmedication.api.enums;

import lombok.Getter;

@Getter
public enum CivilStateEnum {
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    SEPARADO("Separado"),
    DIVORCIADO("Divorciado"),
    VIUVO("Vi\u00FAvo");

    private String name;

    private CivilStateEnum(String name) {
        this.name = name;
    }
}