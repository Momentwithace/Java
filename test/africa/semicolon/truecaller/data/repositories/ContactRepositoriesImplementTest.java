package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactRepositoriesImplementTest {

    @Test
    public void saveContact_countIncreaseTest(){
        ContactRepositories contactRepositories = new ContactRepositoriesImplement();
        Contact contact = new Contact();
        contact.setFirstName("Ace");
        contact.setSecondName("Odogwu");
        contact.setPhoneNumber("111111");
        contact.setEmail("ace@gmail.go");
        contactRepositories.save(contact);
        assertEquals(1, contactRepositories.count());

    }

    @Test
    public void saveContact_findByTest(){
        ContactRepositories contactRepositories = new ContactRepositoriesImplement();
        Contact contact = new Contact();
        contact.setFirstName("Ace");
        contact.setSecondName("Odogwu");
        contact.setPhoneNumber("111111");
        contact.setEmail("ace@gmail.go");
        contactRepositories.save(contact);
        assertEquals(1, contactRepositories.count());
        Contact savedContact = contactRepositories.findById(1);
        assertEquals("Ace", savedContact.getFirstName());

    }

    @Test
    public void deleteContactById() {
        ContactRepositories contactRepositories = new ContactRepositoriesImplement();
        Contact contact = new Contact();
        Contact contactTwo = new Contact();

        contact.setFirstName("Ace");
        contact.setSecondName("Odogwu");
        contact.setPhoneNumber("111111");
        contact.setEmail("ace@gmail.go");
        contactRepositories.save(contact);
        contactTwo.setFirstName("Eden");
        contactTwo.setSecondName("Elenwoke");
        contactTwo.setPhoneNumber("22222");
        contactTwo.setEmail("eden@gmail.go");
        contactRepositories.save(contactTwo);
        assertEquals(2, contactRepositories.count());
        contactRepositories.delete(1);
        assertEquals("Eden", contactTwo.getFirstName());
        assertEquals(2, contactTwo.getId());
    }

    @Test
    public void findByFirstName() {
        ContactRepositories contactRepositories = new ContactRepositoriesImplement();
        Contact contact = new Contact();
        Contact contactTwo = new Contact();
        Contact contactThree = new Contact();
        contact.setFirstName("Ace");
        contact.setSecondName("Odogwu");
        contact.setPhoneNumber("111111");
        contact.setEmail("ace@gmail.go");
        contactRepositories.save(contact);
        contactTwo.setFirstName("Eden");
        contactTwo.setSecondName("Elenwoke");
        contactTwo.setPhoneNumber("22222");
        contactTwo.setEmail("eden@gmail.go");
        contactRepositories.save(contactTwo);
        contactThree.setFirstName("Ace");
        contactThree.setSecondName("Enwe");
        contactThree.setPhoneNumber("333333");
        contactThree.setEmail("ace1@gmail.go");
        contactRepositories.save(contactThree);
        assertEquals(2, contactRepositories.findByFirstName("Ace").size());

    }

    @Test
    public void findByLastName() {
        ContactRepositories contactRepositories = new ContactRepositoriesImplement();
        Contact contact = new Contact();
        Contact contactTwo = new Contact();
        Contact contactThree = new Contact();
        contact.setFirstName("Ace");
        contact.setSecondName("Odogwu");
        contact.setPhoneNumber("111111");
        contact.setEmail("ace@gmail.go");
        contactRepositories.save(contact);
        contactTwo.setFirstName("Eden");
        contactTwo.setSecondName("Elenwoke");
        contactTwo.setPhoneNumber("22222");
        contactTwo.setEmail("eden@gmail.go");
        contactRepositories.save(contactTwo);
        contactThree.setFirstName("Ace");
        contactThree.setSecondName("Odogwu");
        contactThree.setPhoneNumber("333333");
        contactThree.setEmail("ace1@gmail.go");
        contactRepositories.save(contactThree);
        assertEquals(2, contactRepositories.findByLastName("Odogwu").size());
    }

    @Test
    public void update() {
        ContactRepositories contactRepositories = new ContactRepositoriesImplement();
        Contact contact = new Contact();
        Contact contactTwo = new Contact();
        contact.setFirstName("Ace");
        contact.setSecondName("Odogwu");
        contact.setPhoneNumber("111111");
        contact.setEmail("ace@gmail.go");
        contactRepositories.save(contact);
        assertEquals(1, contact.getId());
        contact.setFirstName("Bread");
        contact.setSecondName("Tea");
        contactRepositories.save(contact);
        contactTwo.setFirstName("Eden");
        contactTwo.setSecondName("Elenwoke");
        contactRepositories.save(contactTwo);
        assertEquals("Bread", contact.getFirstName());
        assertEquals(1, contact.getId());
        assertEquals(2, contactTwo.getId());
        assertEquals(2, contactRepositories.count());

    }

}