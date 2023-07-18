package fmt.labmedication.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fmt.labmedication.api.entitites.AddressEntity;
import fmt.labmedication.api.entitites.PatientEntity;
import fmt.labmedication.api.repositories.AddressRepository;
import fmt.labmedication.api.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AddressRepository addressRepository;

    public PatientEntity registerPatient(PatientEntity patient) {
        updateAddressDetails(patient);
        return patientRepository.save(patient);
    }

    public PatientEntity updatePatient(PatientEntity updatedPatient) {
        patientRepository.findById(updatedPatient.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
        updateAddressDetails(updatedPatient);
        return patientRepository.save(updatedPatient);
    }

    public List<PatientEntity> getAllPatients() {
        return patientRepository.findAll();
    }

    private void updateAddressDetails(PatientEntity patient) {
        AddressEntity address = addressRepository.findById(patient.getAddress().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereço inválido!"));
        patient.setAddress(address);
    }
}
