package fmt.labmedication.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fmt.labmedication.api.dtos.statistics.ResponseStatisticsDTO;
import fmt.labmedication.api.entitites.MedicationAdministeringEntity;

public interface MedicationAdministeringRepository extends JpaRepository<MedicationAdministeringEntity, Long> {

    public Boolean existsByPatientId(Long id);

    @Query(value = "SELECT P.NAME, COUNT(PATIENT_ID) AS MEDICATIONCOUNT FROM MEDICATIONS_ADMINISTERING M JOIN PATIENTS P ON M.PATIENT_ID = P.ID GROUP BY PATIENT_ID, P.NAME", nativeQuery = true)
    public List<ResponseStatisticsDTO> getMedicationsByPatient();
}
