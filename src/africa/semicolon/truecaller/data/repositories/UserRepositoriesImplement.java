package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRespositoriesimplement implements UserRepositories {
    private int counter;
    private List<User> users = new ArrayList<>();
    @Override
    public User save(User user) {
        var userId = user.getId();
        for (User value : users) {
            if (value.getId() == userId) {
                user.setFirstName(user.getFirstName());
                user.setSecondName(user.getSecondName());
                user.setEmail(user.getEmail());
                user.setPhoneNumber(user.getPhoneNumber());
                return value;
            }
        }
        counter++;
        user.setId(counter);
        users.add(user);
        return user;

    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User delete(int id) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
