package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personservice")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/addresses", produces = "application/json")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }
}
