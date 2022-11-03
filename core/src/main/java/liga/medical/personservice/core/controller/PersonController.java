package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personservice/person")
@Api(value = "API для работы с клиентами")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получение всех клиентов")
    public List<PersonData> getAllPersons() {
        return personService.getAllPersons();
    }
}
