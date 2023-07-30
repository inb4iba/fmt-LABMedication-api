package fmt.labmedication.api.dtos.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ResponseStatisticsDTO {
    @JsonProperty("nome")
    String getName();

    @JsonProperty("total_medicamentos")
    Integer getMedicationCount();
}
