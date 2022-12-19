package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.repositories.ContactRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactRepositoriesImplement implements ContactRepositories {
    private int counter;
    private List<Contact> contacts = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {
        var contactId = contact.getId();
        for (Contact value : contacts) {
            if (value.getId() == contactId) {
                contact.setFirstName(contact.getFirstName());
                contact.setSecondName(contact.getSecondName());
                contact.setEmail(contact.getEmail());
                contact.setPhoneNumber(contact.getPhoneNumber());

                return value;
            }
        }
        counter++;
        contact.setId(counter);
        contacts.add(contact);
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        var contactId = contact.getId();
        for (Contact aContact : contacts) {
            if (aContact.getId() == contactId)
                contacts.remove(aContact);
            return;
        }
        throw new IllegalArgumentException("Contact with " + contact.getId() + " does not exist!");
    }

    @Override
    public void delete(int id) {
        for (Contact aContact : contacts) {
            if (aContact.getId() == id) {
                contacts.remove(aContact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact with " + id + " does not exist!");
    }

    @Override
    public Contact findById(int id) {
        for (var aContact : contacts) {
            if (aContact.getId() == id)
                return aContact;
        }
        throw new IllegalArgumentException("Contact with " + id + " does not exist!");
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        List<Contact> newList = new ArrayList<>();
        for (Contact contact : contacts) {
            if (Objects.equals(contact.getFirstName(), firstName)) {
                newList.add(contact);
            }
        }
        return newList;
    }

    @Override
    public List<Contact> findByLastName(String lastName) {
        List<Contact> newList = new ArrayList<>();
        for (Contact contact : contacts) {
            if (Objects.equals(contact.getSecondName(), lastName)) {
                newList.add(contact);
            }
        }
        return newList;
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public int count() {
        return contacts.size();
    }
}
