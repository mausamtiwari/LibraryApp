package be.intecbrussel.model.user;

import be.intecbrussel.model.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import be.intecbrussel.repository.UserRepository;

public class User {
    private int userId;
    private String userName;

    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    UserRepository userRepository;


    public User() {
    }

    public User(int userId, String userName, String firstName, String lastName, String emailId, String password) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static List<User> getUserList() {
        UserRepository userRepository = new UserRepository();
        return userRepository.getUserList();
    }

    public Optional<User> getUserById(int userId) {
        return userRepository.getUserList().stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst();
    }

    public Optional<User> getUserByUserName(String userName) {
        return userRepository.getUserList().stream()
                .filter(user -> Objects.equals(user.getUserName(), userName))
                .findFirst();
    }


    @Override
    public String toString() {
        return
                "  userId  " + userId +
                        "  First Name " + firstName +
                        "  last Name  " + lastName +
                        "  emailId" + emailId +
                        " password   " + password;
    }
}
