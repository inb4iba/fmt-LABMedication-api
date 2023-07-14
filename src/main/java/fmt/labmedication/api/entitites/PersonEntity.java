package fmt.labmedication.api.entitites;

import java.time.LocalDate;

import fmt.labmedication.api.enums.CivilStateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String gender;

    @Column(nullable = false)
    LocalDate birthdate;

    @Column(nullable = false, unique = true)
    String cpf;

    @Column(nullable = false)
    String rg;

    @Column(nullable = false)
    CivilStateEnum civilState;

    String telephone;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String nationality;
}
