package be.intecbrussel.model.user;

public class Admin extends User {

    public Admin() {
    }

    public Admin(int userId, String userName, String firstName, String lastName, String emailId, String password) {
        super(userId, userName, firstName, lastName, emailId, password);
    }
}
