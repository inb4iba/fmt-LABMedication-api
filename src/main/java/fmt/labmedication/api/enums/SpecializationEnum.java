package fmt.labmedication.api.enums;

import lombok.Getter;

@Getter
public enum SpecializationEnum {
    CLINICO_GERAL("Clínico Geral"),
    ANESTESISTA("Anestesista"),
    DERMATOLOGIA("Dermatologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    PSIQUIATRIA("Psiquiatria"),
    ORTOPEDIA("Ortopedia");

    private String specialization;

    private SpecializationEnum(String specialization) {
        this.specialization = specialization;
    }
}
