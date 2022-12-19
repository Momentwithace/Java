package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.repositories.ContactRepositories;
import africa.semicolon.truecaller.dtos.responses.ContactResponse;
import africa.semicolon.truecaller.utils.Mapper;

public class ContactServiceImplement implements ContactService {

    ContactRepositories contactRepositories;

    ContactResponse contactResponse = new ContactResponse();

    @Override
    public Contact saveContact(Contact contact){
        Contact addNewContact = new Contact();
        Mapper.map(contact, addNewContact);
        contactRepositories.save(addNewContact);
        var response = contactResponse.getMessage();
        return addNewContact;
    }

    @Override
    public int getNumberOfContacts(){
        return contactRepositories.count();
    }
}
