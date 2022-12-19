package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.repositories.ContactRepositories;
import africa.semicolon.truecaller.data.repositories.ContactRepositoriesImplement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactServiceImplementTest {

    @Test
    void testThatContactIsAdded(){
        ContactRepositories contactRepositories = new ContactRepositoriesImplement();
        ContactService contactService = new ContactServiceImplement();
        Contact contact = new Contact();
        contact.setFirstName("Ace");
        contact.setSecondName("Black");
        contact.setEmail("ace@gmail.com");
        contact.setPhoneNumber("09089786756");
        contactService.saveContact(contact);
        assertEquals(1, contactService.getNumberOfContacts());
        assertEquals(1, contact.getId());
    }
}
