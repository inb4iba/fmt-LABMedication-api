package fmt.labmedication.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fmt.labmedication.api.entitites.AddressEntity;
import fmt.labmedication.api.entitites.PatientEntity;
import fmt.labmedication.api.repositories.AddressRepository;
import fmt.labmedication.api.repositories.MedicationAdministeringRepository;
import fmt.labmedication.api.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    MedicationAdministeringRepository medicationAdministeringRepository;

    public PatientEntity registerPatient(PatientEntity patient) {
        updateAddressDetails(patient);
        return patientRepository.save(patient);
    }

    public PatientEntity updatePatient(PatientEntity updatedPatient) {
        getPatientById(updatedPatient.getId());
        updateAddressDetails(updatedPatient);
        return patientRepository.save(updatedPatient);
    }

    public List<PatientEntity> getAllPatients(String name) {
        if (name == null)
            return patientRepository.findAll();
        return patientRepository.findAllByNameContainingIgnoreCase(name);
    }

    public PatientEntity getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
    }

    public void deletePatient(Long id) {
        getPatientById(id);
        checkIfPatientHasMedicationRegister(id);
        patientRepository.deleteById(id);
    }

    private void checkIfPatientHasMedicationRegister(Long patientId) {
        if (medicationAdministeringRepository.existsByPatientId(patientId))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Paciente possui registros de medicamento administrado!");
    }

    private void updateAddressDetails(PatientEntity patient) {
        AddressEntity address = addressRepository.findById(patient.getAddress().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereço inválido!"));
        patient.setAddress(address);
    }
}
