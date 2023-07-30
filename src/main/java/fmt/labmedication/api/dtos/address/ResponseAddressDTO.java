package fmt.labmedication.api.dtos.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAddressDTO {
    Long id;

    String cep;

    String city;

    String state;

    String street;

    int number;

    String complement;

    String district;

    String reference;
}
