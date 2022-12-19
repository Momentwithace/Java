package africa.semicolon.truecaller.utils;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.models.User;
import africa.semicolon.truecaller.dtos.requests.ContactRequest;
import africa.semicolon.truecaller.dtos.requests.RegisterRequest;

public class Mapper {
    public static void map(RegisterRequest registerRequest, User newUserToAdd) {
        newUserToAdd.setEmail(registerRequest.getEmail());
        newUserToAdd.setLastName(registerRequest.getLastName());
        newUserToAdd.getFirstName(registerRequest.getFirstName());
        newUserToAdd.setPin(registerRequest.getPin());
    }

    public static void map(Contact contact, Contact newContact) {
        newContact.setFirstName(contact.getFirstName());
        newContact.setSecondName(contact.getSecondName());
        newContact.setEmail(contact.getEmail());
        newContact.setPhoneNumber(contact.getPhoneNumber());
    }

    public static void map(ContactRequest contactRequest, Contact newContact) {
        newContact.setFirstName(contactRequest.getFirstName());
        newContact.setSecondName(contactRequest.getLastName());
        newContact.setEmail(contactRequest.getEmail());
        newContact.setPhoneNumber(contactRequest.getPhoneNumber());
    }


}

