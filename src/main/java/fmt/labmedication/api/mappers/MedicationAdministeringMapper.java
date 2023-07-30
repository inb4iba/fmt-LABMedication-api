package fmt.labmedication.api.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import fmt.labmedication.api.dtos.medicationAdministering.RegisterMedicationAdministeringDTO;
import fmt.labmedication.api.dtos.medicationAdministering.ResponseMedicationAdministeringDTO;
import fmt.labmedication.api.entitites.MedicationAdministeringEntity;

@Component
public class MedicationAdministeringMapper {

    private ModelMapper mapper;

    public MedicationAdministeringMapper(ModelMapper mapper) {
        this.mapper = mapper;
        this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ResponseMedicationAdministeringDTO toDto(MedicationAdministeringEntity medicationAdministering) {
        mapper.typeMap(MedicationAdministeringEntity.class, ResponseMedicationAdministeringDTO.class).addMapping(
                (src) -> src.getPatient().getId(),
                ResponseMedicationAdministeringDTO::setPatientId);
        mapper.typeMap(MedicationAdministeringEntity.class, ResponseMedicationAdministeringDTO.class).addMapping(
                (src) -> src.getDoctor().getId(),
                ResponseMedicationAdministeringDTO::setDoctorId);
        return mapper.map(medicationAdministering, ResponseMedicationAdministeringDTO.class);
    }

    public MedicationAdministeringEntity toEntity(RegisterMedicationAdministeringDTO medicationAdministeringDTO) {
        return mapper.map(medicationAdministeringDTO, MedicationAdministeringEntity.class);
    }
}
