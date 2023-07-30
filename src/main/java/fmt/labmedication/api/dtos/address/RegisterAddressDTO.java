package fmt.labmedication.api.dtos.address;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAddressDTO {
    @NotBlank
    String cep;

    @NotBlank
    @JsonProperty("cidade")
    String city;

    @NotBlank
    @JsonProperty("estado")
    String state;

    @NotBlank
    @JsonProperty("logradouro")
    String street;

    @NotNull
    @JsonProperty("numero")
    Integer number;

    @JsonProperty("complemento")
    String complement;

    @NotBlank
    @JsonProperty("bairro")
    String district;

    @JsonProperty("ponto_referencia")
    String reference;
}
