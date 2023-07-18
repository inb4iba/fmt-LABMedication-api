package fmt.labmedication.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fmt.labmedication.api.entitites.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

}
