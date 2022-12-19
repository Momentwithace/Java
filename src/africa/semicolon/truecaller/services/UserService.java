package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.dtos.requests.ContactRequest;
import africa.semicolon.truecaller.dtos.requests.RegisterRequest;
import africa.semicolon.truecaller.dtos.responses.ContactResponse;
import africa.semicolon.truecaller.dtos.responses.RegisterUserResponse;

import java.util.List;

public interface UserService {
    RegisterUserResponse register(RegisterRequest registerRequest);

    int numberOfUsers();

    void deleteContact(String contact);

    List<Contact> findContactsBelongingTo(String email);

    ContactResponse addContact(ContactRequest contactRequest);
}
