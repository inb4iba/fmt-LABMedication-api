package fmt.labmedication.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fmt.labmedication.api.dtos.address.RegisterAddressDTO;
import fmt.labmedication.api.dtos.address.ResponseAddressDTO;
import fmt.labmedication.api.entitites.AddressEntity;
import fmt.labmedication.api.mappers.AddressMapper;
import fmt.labmedication.api.services.AddressService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class AddressController {

    @Autowired
    private AddressMapper mapper;

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<ResponseAddressDTO> registerAddress(
            @Valid @RequestBody RegisterAddressDTO registerAddressDTO) {
        AddressEntity address = mapper.toEntity(registerAddressDTO);
        return new ResponseEntity<ResponseAddressDTO>(mapper.toDto(addressService.registerAddress(address)),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseAddressDTO>> getAllAddresses() {
        return new ResponseEntity<List<ResponseAddressDTO>>(
                addressService.getAllAddresses().stream().map(address -> mapper.toDto(address)).toList(),
                HttpStatus.OK);
    }
}
