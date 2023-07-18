package fmt.labmedication.api.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fmt.labmedication.api.dtos.patient.RegisterPatientDTO;
import fmt.labmedication.api.dtos.patient.ResponsePatientDTO;
import fmt.labmedication.api.entitites.PatientEntity;

@Component
public class PatientMapper {

    @Autowired
    private ModelMapper mapper;

    public ResponsePatientDTO toDto(PatientEntity patient) {
        return mapper.map(patient, ResponsePatientDTO.class);
    }

    public PatientEntity toEntity(RegisterPatientDTO patientDto) {
        return mapper.map(patientDto, PatientEntity.class);
    }
}
