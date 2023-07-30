package fmt.labmedication.api.dtos.address;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAddressDTO {
    Long id;

    String cep;

    @JsonProperty("cidade")
    String city;

    @JsonProperty("estado")
    String state;

    @JsonProperty("logradouro")
    String street;

    @JsonProperty("numero")
    int number;

    @JsonProperty("complemento")
    String complement;

    @JsonProperty("bairro")
    String district;

    @JsonProperty("ponto_referencia")
    String reference;
}
