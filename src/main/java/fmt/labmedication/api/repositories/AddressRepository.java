package fmt.labmedication.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fmt.labmedication.api.entitites.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
