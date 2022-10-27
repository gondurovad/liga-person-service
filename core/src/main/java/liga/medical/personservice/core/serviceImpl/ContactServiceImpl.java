package liga.medical.personservice.core.serviceImpl;

import liga.medical.personservice.core.mapping.ContacMapper;
import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContacMapper contactMapper;

    public ContactServiceImpl(ContacMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactMapper.getAllContacts();
    }

    @Override
    public Contact getContactByPersonId(long id) {
        return contactMapper.getContactByPersonId(id);
    }

    @Override
    public void updateContact(Contact contact) {
        contactMapper.updateContact(contact);
    }
}
