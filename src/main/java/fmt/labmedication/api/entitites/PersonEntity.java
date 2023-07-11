package fmt.labmedication.api.entitites;

import java.time.LocalDate;

import fmt.labmedication.api.enums.CivilStateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String gender;

    @Column(nullable = false)
    LocalDate birthDate;

    @Column(nullable = false)
    String cpf;

    @Column(nullable = false)
    String rg;

    @Column(nullable = false)
    CivilStateEnum civil_state;

    String telephone;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String nationality;
}
