package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;

public interface ContactService {

    Contact saveContact(Contact contact);

    int getNumberOfContacts();
}
