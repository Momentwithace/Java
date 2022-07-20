package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoriesImplement implements UserRepositories {
    private int counter;
    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        var userId = user.getId();
        for (User value : users) {
            if (value.getId() == userId) {
                user.setFirstName(user.getFirstName());
                user.setLastName(user.getLastName());
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
    public void delete(User user) {
        var aUser = existsById(user.getId());
        if (aUser != null) {
            users.remove(aUser);
        }

//        var userId = user.getId();
//        for (User aUser : users) {
//            if (aUser.getId() == userId) {
//                users.remove(aUser);
//                return;
//            }
//        }
//        throw new IllegalArgumentException("Contact with " + user.getId() + " does not exist");
    }

    User existsById(int id) {
        for (User aUser : users) {
            if (aUser.getId() == id) {
                return aUser;
            }
        }
        throw new IllegalArgumentException("User with " + id + " does not exist!");
    }

    @Override
    public void delete(int id) {
        var user = existsById(id);
        if (user != null) {
            users.remove(user);
        }

    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        throw new IllegalArgumentException("User with " + id + " does not exist!");
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        List<User> newList = new ArrayList<>();
        for (User user : users) {
            if (Objects.equals(user.getFirstName(), firstName)) {
                newList.add(user);
            }
        }
        return newList;

    }

    @Override
    public List<User> findByLastName(String lastName) {
        List<User> newList = new ArrayList<>();
        for (User user : users) {
            if (Objects.equals(user.getLastName(), lastName)) {
                newList.add(user);
            }
        }
        return newList;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public int count() {
        return users.size();
    }
}
