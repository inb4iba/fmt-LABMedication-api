package fmt.labmedication.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fmt.labmedication.api.entitites.MedicationAdministeringEntity;

public interface MedicationAdministeringRepository extends JpaRepository<MedicationAdministeringEntity, Long> {

    public Boolean existsByPatientId(Long id);
}
