package be.intecbrussel;


import be.intecbrussel.model.book.FindType;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.repository.UserRepository;
import be.intecbrussel.service.BookService;
import be.intecbrussel.service.UserService;
import be.intecbrussel.model.book.SortType;


import java.util.Scanner;

public class MainLibraryApp {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        BookRepository bookRepository = new BookRepository();
        UserRepository userRepository = new UserRepository();
        BookService bookService = new BookService(bookRepository, userRepository);
        UserService userService = new UserService(bookRepository, userRepository);
        FindType findType;
        SortType sortType;

        System.out.println("Welcome to Alexandria.");
        System.out.println("Enter your status admin/member");
        String status = myScanner.nextLine().toLowerCase();

        char ans = 0;
        System.out.println("Kindly choose the method you want to perform");
        switch (status) {
            case "admin": {
                System.out.println("Welcome Admin! You have access to administrative features.");
                do {
                    System.out.println("1.Add Book");
                    System.out.println("2.Find Book");
                    System.out.println("3.Remove Book");
                    // System.out.println("4.Sort Book");
                    System.out.println("5.update Book Record");
                    System.out.println("6.Count Book");
                    System.out.println("7.Issue Book");
                    System.out.println("8.Renew Book");
                    System.out.println("9.Return All Book");
                    System.out.println("10.Return BookByIDNO");
                    System.out.println("11.Browse Books");
                    System.out.println("12. Add Member");
                    System.out.println("13.Remove Member");
                    // System.out.println("14.Search Member");
                    System.out.println("15. Update member info");
                    System.out.println("16.List Member");
                    //System.out.println("17. Send warning");
                    System.out.println("18.Exit");

                    int choice = myScanner.nextInt();

                    switch (choice) {
                        case 1: {
                            bookService.addBook();
                            break;
                        }
                        case 2: {
                            System.out.println("How do you want to find a book: Title/Author/ID");
                            myScanner.nextLine();
                            String searchType = myScanner.nextLine().toLowerCase();
                            switch (searchType) {
                                case "title":
                                    findType = FindType.TITLE;
                                    break;
                                case "author":
                                    findType = FindType.AUTHOR;
                                    break;
                                case "id":
                                    findType = FindType.ID;
                                    break;
                                default:
                                    System.out.println("Invalid search type.");
                                    continue;
                            }
                            bookService.findTypeControl(findType);
                            break;
                        }


                        case 3: {
                            bookService.removeBook();
                            break;
                        }

                        /*case 4: {
                            System.out.println("How do you want to sort the booklist: title/author/id/publishyear");
                            myScanner.nextLine();
                            String sort = myScanner.nextLine().toLowerCase();
                            switch (sort) {
                                case "title":
                                    sortType = SortType.TITLE;
                                    break;

                                case "author":
                                    sortType = SortType.AUTHOR;
                                    break;

                                case "id":
                                    sortType = SortType.ID;
                                    break;

                                case "publishyear":
                                    sortType = SortType.PUBLISHYEAR;
                                    break;

                                default:
                                    System.out.println("Invalid search type.");
                                    continue;
                            }
                            bookService.sortTypeControl(sortType);
                            break;
                        }*/
                        case 5:
                            bookService.updateBookRecord();
                            break;
                        case 6:
                            bookService.countBooks();
                            break;
                        case 7:
                            bookService.issueBook();
                            break;
                        case 8:
                            bookService.renewBook();
                            break;
                        case 9:
                            bookService.returnAllBooks();
                            break;
                        case 10:
                            bookService.returnBookByBookIDNO();
                            break;
                        case 11:
                            bookService.browseBooks();

                            break;
                       /* case 12:
                            userService.addMember();
                            break;*/
                        case 13:
                            userService.removeMember();
                            break;
                        case 14:
                            //userService.searchMember();
                            break;
                        case 15:
                            userService.updateMemberInfo();
                            break;
                        case 16:
                            userService.listMembers();
                        case 17:
                            //userService.sendWarning();
                        case 18:
                            continue;
                        default:
                            System.out.println("Invalid choice");
                    }

                    System.out.println("Do you want to continue again (y/n)");
                    ans = myScanner.next().charAt(0);

                } while (ans == 'y' || ans == 'Y');
                break;
            }


            case "member": {
                System.out.println("Welcome member! You have access to member features.");

                do {
                    System.out.println("Kindly Enter your choice");
                    System.out.println("1.Find Book");
                    System.out.println("2.Browse member info");
                    System.out.println("3.Browse Book");
                    System.out.println("4.Reserve Book");
                    System.out.println("5.Borrow Book");
                    System.out.println("6. ReturnBooksById");
                    System.out.println("7. ReturnAllBooks");
                    System.out.println("8.Exit");

                    int choice = myScanner.nextInt();
                    myScanner.nextLine();
                    switch (choice) {
                        case 1: {
                            System.out.println("How do you want to find a book: Title/Author/ID");
                            String searchType = myScanner.nextLine().toLowerCase();
                            switch (searchType) {
                                case "title":
                                    findType = FindType.TITLE;
                                    break;
                                case "author":
                                    findType = FindType.AUTHOR;
                                    break;
                                case "id":
                                    findType = FindType.ID;
                                    break;
                                default:
                                    System.out.println("Invalid search type.");
                                    continue;
                            }
                            bookService.findTypeControl(findType);
                            break;
                        }

                        case 2:
                            userService.browseMemberInfo();
                            break;
                        case 3:
                            bookService.browseBooks();
                            break;
                        case 4:
                            bookService.reserveBook();
                            break;
                        case 5:
                            bookService.borrowBook();
                            break;
                        case 6:
                            bookService.returnBookByBookIDNO();
                            continue;
                        case 7:
                           bookService.returnAllBooks();
                        case 8:
                            continue;
                        default:
                            System.out.println("Invalid choice");
                    }

                    System.out.println("Do you want to continue again (y/n)");
                    ans = myScanner.next().charAt(0);

                } while (ans == 'y' || ans == 'Y');
                break;
            }
            default:
                System.out.println("Invalid status");
        }


    }
}