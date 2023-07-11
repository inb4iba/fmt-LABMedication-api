package fmt.labmedication.api.enums;

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
}
