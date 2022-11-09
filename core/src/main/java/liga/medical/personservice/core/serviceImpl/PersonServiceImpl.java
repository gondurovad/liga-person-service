package liga.medical.personservice.core.serviceImpl;

import liga.medical.personservice.core.mapping.PersonMapper;
import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @Override
    public List<PersonData> getAllPersons() {
        return personMapper.getAllPersons();
    }

    @Override
    public PersonData getById(Long id) {
        return personMapper.getById(id);
    }
}
