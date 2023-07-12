package fmt.labmedication.api.entitites;

import fmt.labmedication.api.enums.SpecialtyEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class UserEntity extends PersonEntity {
    @Column(nullable = false)
    String crm;

    @Column(nullable = false)
    SpecialtyEnum specialty;

    @Column(nullable = false)
    String password;
}