package fmt.labmedication.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fmt.labmedication.api.dtos.statistics.ResponseStatisticsDTO;
import fmt.labmedication.api.services.MedicationAdministeringService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/estatisticas")
public class StatisticsController {

    @Autowired
    private MedicationAdministeringService medicationAdministeringService;

    @GetMapping()
    public ResponseEntity<List<ResponseStatisticsDTO>> getStatistics() {
        return new ResponseEntity<List<ResponseStatisticsDTO>>(medicationAdministeringService.getStatistics(),
                HttpStatus.OK);
    }

}
