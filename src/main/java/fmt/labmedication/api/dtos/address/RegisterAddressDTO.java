package fmt.labmedication.api.dtos.address;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAddressDTO {
    @NotBlank
    String cep;

    @NotBlank
    String city;

    @NotBlank
    String state;

    @NotBlank
    String street;

    @NotBlank
    int number;

    String complement;

    @NotBlank
    String district;

    String reference;
}
