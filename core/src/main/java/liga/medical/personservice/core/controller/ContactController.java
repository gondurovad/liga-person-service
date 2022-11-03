package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "API для работы с контактами клиентов")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получение всех существующих контактов")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping(path = "/byperson/{personId}", produces = "application/json")
    @ApiOperation(value = "Получение контактов по id клиента")
    public Contact getContactByPersonId(@PathVariable(value = "personId") long personId) {
        return contactService.getContactByPersonId(personId);
    }

    @PatchMapping(path = "/update")
    @ApiOperation(value = "Обновление контактов клиента")
    public ResponseEntity<String> updateContact(@RequestBody Contact contact) {
        if (contact.getPhoneNumber().isEmpty())
            return new ResponseEntity<>("Incorrect data was sent. Check that the phone number are entered correctly.", HttpStatus.BAD_REQUEST);
        else {
            contactService.updateContact(contact);
            return new ResponseEntity<>("Contact was updated.", HttpStatus.OK);
        }
    }
}
