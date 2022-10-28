package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/personservice/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping(path = "/byperson/{personId}", produces = "application/json")
    public Contact getContactByPersonId(@PathVariable(value = "personId") long personId) {
        return contactService.getContactByPersonId(personId);
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<String> updateContact(@RequestBody Contact contact) {
        if (contact.getPhoneNumber().isEmpty())
            return new ResponseEntity<>("Incorrect data was sent. Check that the phone number are entered correctly.", HttpStatus.BAD_REQUEST);
        else {
            contactService.updateContact(contact);
            return new ResponseEntity<>("Contact was updated.", HttpStatus.OK);
        }
    }
}
