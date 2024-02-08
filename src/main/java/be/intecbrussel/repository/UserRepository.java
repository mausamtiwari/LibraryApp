package be.intecbrussel.repository;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.user.Admin;
import be.intecbrussel.model.user.Member;
import be.intecbrussel.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {



    private List<User> userList  = new ArrayList<>();

    {
        userList.add(new Admin(1,"Addy","Admin", "Admin", "Admin@Alexandria.org", "11"));
        userList.add(new Member(2,"Deeps","Deepika", "Aggarwala", "Deepika@Alexandria.org", "22"));
        userList.add(new Member(3,"Jhonny","Jonathan", "Deroo", "Jonathan@Alexandria.org", "33"));
        userList.add(new Member(4,"Max","Maxime", "Franquet", "Maxime@Alexandria.org", "44"));
        userList.add(new Member(5,"MSM","Mausam", "Tiwari", "Mausam@Alexandria.org", "55"));
    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Optional<User> getUserById(int userId) {
        return userList.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst();
    }

    public Optional<User> getUserByUserName(String userName) {
        return userList.stream()
                .filter(user -> Objects.equals(user.getUserName(), userName))
                .findFirst();
    }


    public void addUser(User user) {
        userList.add(user);
    }
}
