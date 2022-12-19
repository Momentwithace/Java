package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.models.User;
import africa.semicolon.truecaller.data.repositories.ContactRepositories;
import africa.semicolon.truecaller.data.repositories.ContactRepositoriesImplement;
import africa.semicolon.truecaller.data.repositories.UserRepositories;
import africa.semicolon.truecaller.data.repositories.UserRepositoriesImplement;
import africa.semicolon.truecaller.dtos.requests.RegisterRequest;
import africa.semicolon.truecaller.dtos.responses.ContactResponse;
import africa.semicolon.truecaller.dtos.responses.RegisterUserResponse;
import africa.semicolon.truecaller.exceptions.UserExistsException;
import org.apache.catalina.mapper.Mapper;

import java.util.List;


public class UserServicesImplement implements UserService{

    private final UserRepositories userRepositories;

    private RegisterUserResponse userResponse = new RegisterUserResponse();

    private final ContactService contactService;

    public UserServicesImplement(UserRepositories userRepositories, ContactService contactService){
        this.userRepositories = userRepositories;
        this.contactService = contactService;
    }

    public UserServicesImplement(){
        this.userRepositories = new UserRepositoriesImplement();
        ContactRepositories contactRepositories = new ContactRepositoriesImplement();
        this.contactService = new ContactServiceImplement(contactRepositories);
    }


    @Override
    public RegisterUserResponse register(RegisterRequest registerRequest)  throws UserExistsException {
        validateUser(registerRequest);
        User newUserToAdd = new User();
        Mapper.map(registerRequest, newUserToAdd);
        userRepositories.saveUser(newUserToAdd);
        userResponse.setMessage("User successfully registered");
        return userResponse;
    }
    private void validateUser(RegisterRequest registerRequest){
        var savedUser = userRepositories.findByEmail(registerRequest.getEmail());
        if(savedUser != null){
            throw new UserExistsException("User With " + registerRequest.getEmail() + " already exists");
        }
    }

    @Override
    public int numberOfUsers() {
        return userRepositories.count();
    }

    @Override
    public ContactResponse addContact(ContactResponse contactResponse){
        Contact newContact = new Contact();
        Mapper.map(contactRequest, newContact);
        var savedContact = contactService.saveContact(newContact);
        User user = userRepositories.findByEmail(contactRequest.getUserEmail());
        user.getContacts().add(savedContact):
        return null;
    }

    @Override
    public void deleteContact(String contact) {

    }

    @Override
    public List<Contact> findContactsBelongingTo(String email) {
        var user = userRepositories.findByEmail(email);
        return user.getContacts();
    }
}

