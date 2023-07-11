package fmt.labmedication.api.enums;

import lombok.Getter;

@Getter
public enum CivilStateEnum {
    CLINICO_GERAL("Clínico Geral"),
    ANESTESISTA("Anestesista"),
    DERMATOLOGIA("Dermatologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    PSIQUIATRIA("Psiquiatria"),
    ORTOPEDIA("Ortopedia");

    private String name;

    private CivilStateEnum(String name) {
        this.name = name;
    }
}
