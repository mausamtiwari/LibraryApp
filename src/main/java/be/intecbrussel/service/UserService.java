package be.intecbrussel.service;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.user.User;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserService {
    Scanner myScanner = new Scanner(System.in);
    UserRepository userRepository;
    BookRepository bookRepository;
    User user = new User();

    public UserService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

   /* public void addMember() {
        System.out.println("Enter the details of the new member:");
        System.out.print("Enter userId: ");
        int userId = myScanner.nextInt();
        System.out.print("UserName: ");
        String userName = myScanner.nextLine();
        myScanner.nextLine();
        System.out.print("First Name: ");
        String firstName = myScanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = myScanner.nextLine();
        System.out.print("EmailId: ");
        String emailId = myScanner.nextLine();
        System.out.print("Password: ");
        String password = myScanner.nextLine();

        User user = new User(userId, userName, firstName, lastName, emailId, password);
        Optional<User> optionalUser = userRepository.getUserById(userId);
        if ( optionalUser.isEmpty()) {
            userRepository.addUser(user);
        } else {
            System.out.println("User already present with the same userId.");
        }


    }*/


    public void removeMember() {
        List<User> userList = userRepository.getUserList();
        System.out.println("Please enter the userId to remove: ");
        int userId = myScanner.nextInt();
        Optional<User> userToRemove = userRepository.getUserById(userId);
        if (userToRemove.isPresent()) {
            userList.remove(userToRemove.get());
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found with ID: " + userId);
        }
    }

    public void updateMemberInfo() {
        //List<User> userList = userRepository.getUserList();
        System.out.println("Please enter the userId to updateInfo: ");
        int userId = myScanner.nextInt();
        Optional<User> userToUpdate = userRepository.getUserById(userId);
        if (userToUpdate.isPresent()) {
            User user = userToUpdate.get();
            System.out.print("Enter updated userName: ");
            String userName = myScanner.nextLine();
            System.out.print("Enter updated First Name: ");
            String FirstName = myScanner.nextLine();
            System.out.print("Enter updated LastName: ");
            String LastName = myScanner.nextLine();
            System.out.print("Enter updated password: ");
            String password = myScanner.nextLine();
            myScanner.nextLine();
            user.setUserName(userName);
            user.setUserName(FirstName);
            user.setUserName(LastName);
            user.setUserName(password);

            System.out.println("Book record updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void listMembers() {
        List<User> userList = userRepository.getUserList();
        System.out.println("List of all Users");
        userList.forEach(System.out::println);

    }

    public void browseMemberInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Member ID:");
        int memberId = scanner.nextInt();

        Optional<User> optionalUser = userRepository.getUserById(memberId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println("Member ID: " + user.getUserId());
            System.out.println("Name: " + user.getUserName());
            System.out.println("Email: " + user.getEmailId());
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }
    }
}
