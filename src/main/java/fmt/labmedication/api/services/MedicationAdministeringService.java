package fmt.labmedication.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
