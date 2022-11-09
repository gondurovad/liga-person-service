package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.service.AddressService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@Api(value = "API для работы с адресами клиентов")
@RequestMapping("/personservice/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получение всех существующих адресов")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ApiOperation(value = "Получение адреса по id")
    public Address getAddress(@PathVariable Long id) {
        return addressService.getById(id);
    }

    @PatchMapping(path = "/update", produces = "application/json")
    @ApiOperation(value = "Обновление адреса")
    public void updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
    }

}
