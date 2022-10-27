package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personservice")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/persons", produces = "application/json")
    public List<PersonData> getAllPersons() {
        return personService.getAllPersons();
    }
}
