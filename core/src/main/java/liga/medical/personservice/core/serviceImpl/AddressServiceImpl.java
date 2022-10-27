package liga.medical.personservice.core.serviceImpl;

import liga.medical.personservice.core.mapping.AddressMapper;
import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressMapper.getAllAddresses();
    }
}
