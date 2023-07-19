package fmt.labmedication.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fmt.labmedication.api.dtos.medicationAdministering.RegisterMedicationAdministeringDTO;
import fmt.labmedication.api.dtos.medicationAdministering.ResponseMedicationAdministeringDTO;
import fmt.labmedication.api.entitites.MedicationAdministeringEntity;
import fmt.labmedication.api.mappers.MedicationAdministeringMapper;
import fmt.labmedication.api.services.MedicationAdministeringService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicamentos")
public class MedicationAdministeringController {

    @Autowired
    private MedicationAdministeringService medicationAdministeringService;

    @Autowired
    private MedicationAdministeringMapper mapper;

    @PostMapping
    public ResponseEntity<ResponseMedicationAdministeringDTO> registerMedicationAdministering(
            @Valid @RequestBody RegisterMedicationAdministeringDTO registerMedicationAdministeringDTO) {
        MedicationAdministeringEntity medicationAdministering = mapper.toEntity(registerMedicationAdministeringDTO);
        medicationAdministering = medicationAdministeringService
                .registerMedicationAdministering(medicationAdministering);
        return new ResponseEntity<ResponseMedicationAdministeringDTO>(mapper.toDto(medicationAdministering),
                HttpStatus.CREATED);
    }
}