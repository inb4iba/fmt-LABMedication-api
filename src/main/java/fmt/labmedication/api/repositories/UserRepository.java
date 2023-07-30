package fmt.labmedication.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fmt.labmedication.api.entitites.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public Boolean existsUserByCpf(String cpf);

    public Boolean existsUserByCrm(String crm);
}
