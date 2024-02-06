package be.intecbrussel.repository;

import be.intecbrussel.model.user.Admin;
import be.intecbrussel.model.user.Member;
import be.intecbrussel.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> userList  = new ArrayList<>();

    {
        userList.add(new Admin("Admin", "Admin", "Admin@Alexandria.org", "11"));
        userList.add(new Member("Deepika", "Aggarwala", "Deepika@Alexandria.org", "22"));
        userList.add(new Member("Jonathan", "Deroo", "Jonathan@Alexandria.org", "33"));
        userList.add(new Member("Maxime", "Franquet", "Maxime@Alexandria.org", "44"));
        userList.add(new Member("Mausam", "Tiwari", "Mausam@Alexandria.org", "55"));
    }




}
