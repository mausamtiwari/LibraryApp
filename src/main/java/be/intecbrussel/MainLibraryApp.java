package be.intecbrussel;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.book.ChildrenBooks;
import be.intecbrussel.model.book.FindType;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.service.BookService;

import java.util.Optional;
import java.util.Scanner;

public class MainLibraryApp {


    public static void main(String[] args) {
        char ans = 'y';
        Scanner myScanner = new Scanner(System.in);
        BookService bookService = new BookService(new BookRepository());
        FindType findType;
        System.out.println("Welcome to Alexendria.");
        System.out.println("Enter your status admin/user");
        String status = myScanner.nextLine().toLowerCase();
        do
        {
            System.out.println("Kindly choose the method you want to perform");
            switch (status) {
                case "admin": {
                    System.out.println("1.Add Book");
                    System.out.println("2.Find Book");
                    System.out.println("3.Remove Book");
                    System.out.println("4.Sort Book");
                    System.out.println("5.update Book Record");
                    System.out.println("6.Count Book");
                    System.out.println("7.Issue Book");
                    System.out.println("8.Renew Book");
                    System.out.println("9.Return Book");
                    System.out.println("9.Browse Books");
                    System.out.println("10. Add Member");
                    System.out.println("11.Remove Member");
                    System.out.println("12.Search Member");
                    System.out.println("13. Update member info");
                    System.out.println("14.List Member");
                    System.out.println("15. Send warning");
                    System.out.println("16.Exit");
                    break;
                }
                case "member": {
                    System.out.println("17.Find Book");
                    System.out.println("18.Browse member info");
                    System.out.println("19.Browse Book");
                    System.out.println("20.Reserve Book");
                    System.out.println("21.Exit");
                    break;
                }
                default: {
                    System.out.println("Enter valid choice");
                }

            }

            System.out.println("Kindly Enter your choice");
            int choice = myScanner.nextInt();
            switch (choice) {
                case 1: {
                    try {
                        Book childrenBook = new ChildrenBooks(0, "The Lion Inside", "Rachel Bright", 2016, true);
                        bookService.addBook(childrenBook);
                    } catch (Exception e) {
                        System.out.println("Book info can not be null");
                    }
                    break;

                }
                case 2: {
                    System.out.println("How do you want to find a book Book Title/ Book Author/Book No");
                    System.out.println("Enter your choice");
                    System.out.println("1. Book Title");
                    System.out.println("2. Book Author");
                    System.out.println("3. Book No");
                    choice = myScanner.nextInt();
                    switch (choice) {
                        case 1: {
                            findType = FindType.TITLE;
                            bookService.findTypeControl(findType);
                            break;
                        }
                        case 2: {
                            findType = FindType.AUTHOR;
                            bookService.findTypeControl(findType);
                            break;
                        }
                        case 3: {
                            findType = FindType.ID;
                            bookService.findTypeControl(findType);
                            break;
                        }
                        default: {
                            System.out.println("Invalid choice");
                            break;

                        }
                    }


                }


            }
            System.out.println("Do you want to continue again (y/n)");
             ans = myScanner.next().charAt(0);
        }
        while (ans == 'y'|| ans == 'Y');
    }
}