package fmt.labmedication.api.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fmt.labmedication.api.dtos.address.RegisterAddressDTO;
import fmt.labmedication.api.dtos.address.ResponseAddressDTO;
import fmt.labmedication.api.entitites.AddressEntity;

@Component
public class AddressMapper {
    @Autowired
    private ModelMapper mapper;

    public AddressEntity toEntity(RegisterAddressDTO registerAddressDTO) {
        return mapper.map(registerAddressDTO, AddressEntity.class);
    }

    public ResponseAddressDTO toDto(AddressEntity address) {
        return mapper.map(address, ResponseAddressDTO.class);
    }
}
