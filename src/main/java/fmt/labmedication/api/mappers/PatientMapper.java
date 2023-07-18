package fmt.labmedication.api.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import fmt.labmedication.api.dtos.patient.RegisterPatientDTO;
import fmt.labmedication.api.dtos.patient.ResponsePatientDTO;
import fmt.labmedication.api.entitites.PatientEntity;

@Component
public class PatientMapper {

    private ModelMapper mapper;

    public PatientMapper(ModelMapper mapper) {
        this.mapper = mapper;
        this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ResponsePatientDTO toDto(PatientEntity patient) {
        return mapper.map(patient, ResponsePatientDTO.class);
    }

    public PatientEntity toEntity(RegisterPatientDTO patientDto) {
        mapper.typeMap(RegisterPatientDTO.class, PatientEntity.class).addMapping(RegisterPatientDTO::getAddressId,
                (dest, v) -> dest.getAddress().setId((Long) v));
        return mapper.map(patientDto, PatientEntity.class);
    }
}
