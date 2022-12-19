package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.repositories.ContactRepositories;
import africa.semicolon.truecaller.data.repositories.ContactRepositoriesImplement;
import africa.semicolon.truecaller.data.repositories.UserRepositories;
import africa.semicolon.truecaller.data.repositories.UserRepositoriesImplement;
import africa.semicolon.truecaller.dtos.requests.ContactRequest;
import africa.semicolon.truecaller.dtos.requests.RegisterRequest;
import africa.semicolon.truecaller.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserServiceImplementTest {

    UserService userCreated;
    UserRepositories userRepositories = new UserRepositoriesImplement();
    ContactRepositories contactRepositories = new ContactRepositoriesImplement();
    ContactService contactService = new ContactServiceImplement(contactRepositories);

    RegisterRequest userRequest;
    ContactRequest contactRequest;

    @BeforeEach
    void SetUp(){
        userCreated = new UserServiceImplementTest(userRepositories, contactService);
        userRequest = new RegisterRequest();
        contactRequest = new ContactRequest();
    }

    @Test
    void testThatNewAccountIsCreated(){
        userRequest.setEmail("Tman@gmail.com");
        userRequest.setFirstName("paul");
        userRequest.setLastName("joy");
        userRequest.setPin("1234");
        userCreated.register(userRequest);
        assertEquals(1, userCreated.numberOfUsers());
    }


    @Test
    void testThatDuplicateEmailThrowsException(){
        userRequest.setEmail("Tman@gmail.com");
        userRequest.setFirstName("Boyo");
        userRequest.setLastName("Tom");
        userRequest.setPin("1334");
        userCreated.register(userRequest);

        RegisterRequest userRequest2 = new RegisterRequest();
        userRequest2.setEmail("Tman@gmail.com");
        userRequest2.setFirstName("paul");
        userRequest2.setLastName("joy");
        userRequest2.setPin("1234");
        userCreated.register(userRequest);
        assertEquals(1, userCreated.numberOfUsers());
        assertThrows(UserExistsException.class, () -> userCreated.register(userRequest2));
    }


    @Test
    void testThatAccountCanAddContacts() {
        userRequest.setEmail("Ace@gmail.com");
        userRequest.setFirstName("Boyo");
        userRequest.setLastName("Tom");
        userRequest.setPin("1334");
        userCreated.register(userRequest);

        contactRequest.setEmail("Tman@gmail.com");
        contactRequest.setFirstName("paul");
        contactRequest.setLastName("joy");
        contactRequest.setPhoneNumber("0908767564");
        contactRequest.setUserEmail("Acemail@gmail.com");

        userCreated.addContact(contactRequest);
        assertEquals(1, userCreated.findContactsBelongingTo("Ace@gmail.com").size());
    }
}
