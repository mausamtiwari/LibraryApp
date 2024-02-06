package be.intecbrussel.model.user;

public abstract class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;

    public User(){}
    public User(String firstName, String lastName, String emailId, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
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

    @Override
    public String toString() {
        return
                "  userId  " + userId +
                "  First Name " + firstName +
                "  last Name  " + lastName  +
                "  emailId"   + emailId  +
                " password   " + password ;
    }
}
