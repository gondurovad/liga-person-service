package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.PersonData;

import java.util.List;

public interface PersonService {

    List<PersonData> getAllPersons();

    PersonData getById(Long id);
}
