package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoriesImplementTest {
    @Test
    public void saveUser_countIncreaseTest(){
        UserRepositories userRepositories = new UserRepositoriesImplement();
        User user = new User();
        user.setFirstName("Ace");
        user.setLastName("Odogwu");
        user.setPhoneNumber("111111");
        user.setEmail("ace@gmail.go");
        user.setAddress("sabo");
        userRepositories.save(user);
        assertEquals(1, userRepositories.count());

    }

    @Test
    public void deleteUserUsingId_countDecreaseTest(){
        UserRepositories userRepositories = new UserRepositoriesImplement();
        User user = new User();
        user.setFirstName("Ace");
        user.setLastName("Odogwu");
        user.setPhoneNumber("111111");
        user.setEmail("ace@gmail.go");
        user.setAddress("sabo");
        userRepositories.save(user);
        assertEquals(1, userRepositories.count());
        userRepositories.delete(1);
        assertEquals(0, userRepositories.count());

    }

    @Test
    public void deleteUserUsingContactFirstName_countDecreaseTest(){
        UserRepositories userRepositories = new UserRepositoriesImplement();
        User user = new User();
        user.setFirstName("Ace");
        user.setLastName("Odogwu");
        user.setPhoneNumber("111111");
        user.setEmail("ace@gmail.go");
        user.setAddress("sabo");
        userRepositories.save(user);
        assertEquals(1, userRepositories.count());
        userRepositories.delete(user);
        assertEquals(0,userRepositories.count());

    }

    @Test
    public void findByFirstName() {
        UserRepositories userRepositories = new UserRepositoriesImplement();
        User user = new User();
        User userTwo = new User();
        User userThree = new User();
        user.setFirstName("Ace");
        user.setLastName("Odogwu");
        user.setPhoneNumber("111111");
        user.setEmail("ace@gmail.go");
        user.setAddress("yaba");
        userRepositories.save(user);
        userTwo.setFirstName("Eden");
        userTwo.setLastName("Elenwoke");
        userTwo.setPhoneNumber("22222");
        userTwo.setEmail("eden@gmail.go");
        user.setAddress("sabo");
        userRepositories.save(userTwo);
        userThree.setFirstName("Ace");
        userThree.setLastName("Enwe");
        userThree.setPhoneNumber("333333");
        userThree.setEmail("ace1@gmail.go");
        user.setAddress("barigga");
        userRepositories.save(userThree);
        assertEquals(2, userRepositories.findByFirstName("Ace").size());
        assertEquals(3, userRepositories.count());

    }

    @Test
    public void findByLastName() {
        UserRepositories userRepositories = new UserRepositoriesImplement();
        User user = new User();
        User userTwo = new User();
        User userThree = new User();
        user.setFirstName("Ace");
        user.setLastName("Odogwu");
        user.setPhoneNumber("111111");
        user.setEmail("ace@gmail.go");
        user.setAddress("yaba");
        userRepositories.save(user);
        userTwo.setFirstName("Eden");
        userTwo.setLastName("Elenwoke");
        userTwo.setPhoneNumber("22222");
        userTwo.setEmail("eden@gmail.go");
        user.setAddress("sabo");
        userRepositories.save(userTwo);
        userThree.setFirstName("Ace");
        userThree.setLastName("Enwe");
        userThree.setPhoneNumber("333333");
        userThree.setEmail("ace1@gmail.go");
        user.setAddress("barigga");
        userRepositories.save(userThree);
        assertEquals(1, userRepositories.findByLastName("Odogwu").size());
        assertEquals(3, userRepositories.count());
    }

    @Test
    public void findById(){
        UserRepositories userRepositories = new UserRepositoriesImplement();
        User user = new User();
        User userTwo = new User();
        User userThree = new User();
        user.setFirstName("Ace");
        user.setLastName("Odogwu");
        user.setPhoneNumber("111111");
        user.setEmail("ace@gmail.go");
        user.setAddress("yaba");
        userRepositories.save(user);
        userTwo.setFirstName("Eden");
        userTwo.setLastName("Elenwoke");
        userTwo.setPhoneNumber("22222");
        userTwo.setEmail("eden@gmail.go");
        user.setAddress("sabo");
        userRepositories.save(userTwo);
        userThree.setFirstName("Ace");
        userThree.setLastName("Enwe");
        userThree.setPhoneNumber("333333");
        userThree.setEmail("ace1@gmail.go");
        user.setAddress("barigga");
        userRepositories.save(userThree);
        assertEquals(3, userRepositories.count());
        assertEquals("Ace", userRepositories.findById(1).getFirstName(registerRequest.getFirstName()));
    }

    @Test
    public void findAllUser(){
        UserRepositories userRepositories = new UserRepositoriesImplement();
        User user = new User();
        User userTwo = new User();
        User userThree = new User();
        user.setFirstName("Ace");
        user.setLastName("Odogwu");
        user.setPhoneNumber("111111");
        user.setEmail("ace@gmail.go");
        user.setAddress("yaba");
        userRepositories.save(user);
        userTwo.setFirstName("Eden");
        userTwo.setLastName("Elenwoke");
        userTwo.setPhoneNumber("22222");
        userTwo.setEmail("eden@gmail.go");
        user.setAddress("sabo");
        userRepositories.save(userTwo);
        userThree.setFirstName("Ace");
        userThree.setLastName("Enwe");
        userThree.setPhoneNumber("333333");
        userThree.setEmail("ace1@gmail.go");
        user.setAddress("barigga");
        userRepositories.save(userThree);
        assertEquals(3, userRepositories.count());
        assertEquals(3, userRepositories.findAll().size());
    }

}
