package fmt.labmedication.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fmt.labmedication.api.dtos.patient.RegisterPatientDTO;
import fmt.labmedication.api.dtos.patient.ResponsePatientDTO;
import fmt.labmedication.api.entitites.PatientEntity;
import fmt.labmedication.api.mappers.PatientMapper;
import fmt.labmedication.api.services.PatientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    PatientMapper mapper;

    @PostMapping
    public ResponseEntity<ResponsePatientDTO> registerPatient(
            @Valid @RequestBody RegisterPatientDTO registerPatientDTO) {
        PatientEntity patient = mapper.toEntity(registerPatientDTO);
        patient = patientService.registerPatient(patient);
        return new ResponseEntity<ResponsePatientDTO>(mapper.toDto(patient), HttpStatus.CREATED);
    }
}
