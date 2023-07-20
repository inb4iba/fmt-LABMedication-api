package fmt.labmedication.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fmt.labmedication.api.entitites.AddressEntity;
import fmt.labmedication.api.repositories.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressEntity registerAddress(AddressEntity address) {
        return addressRepository.save(address);
    }
}
