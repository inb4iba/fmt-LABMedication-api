package fmt.labmedication.api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fmt.labmedication.api.dtos.medicationAdministering.UpdateMedicationAdministeringDTO;
import fmt.labmedication.api.dtos.statistics.ResponseStatisticsDTO;
import fmt.labmedication.api.entitites.MedicationAdministeringEntity;
import fmt.labmedication.api.repositories.MedicationAdministeringRepository;

@Service
public class MedicationAdministeringService {

    @Autowired
    private MedicationAdministeringRepository medicationAdministeringRepository;

    public MedicationAdministeringEntity registerMedicationAdministering(
            MedicationAdministeringEntity medicationAdministering) {
        return medicationAdministeringRepository.save(medicationAdministering);
    }

    public MedicationAdministeringEntity updateMedicationAdministering(
            UpdateMedicationAdministeringDTO medicationAdministeringDTO, Long id) {
        MedicationAdministeringEntity medicationAdministering = getMedicationAdministeringById(id);
        BeanUtils.copyProperties(medicationAdministeringDTO, medicationAdministering);
        return medicationAdministering;
    }

    public MedicationAdministeringEntity getMedicationAdministeringById(Long id) {
        return medicationAdministeringRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado!"));
    }

    public void deleteMedicationAdministering(Long id) {
        getMedicationAdministeringById(id);
        medicationAdministeringRepository.deleteById(id);
    }

    public List<ResponseStatisticsDTO> getStatistics() {
        return medicationAdministeringRepository.getMedicationsByPatient();
    }
}
