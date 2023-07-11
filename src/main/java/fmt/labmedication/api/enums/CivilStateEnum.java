package fmt.labmedication.api.enums;

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
}