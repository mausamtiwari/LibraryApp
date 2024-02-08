package be.intecbrussel.service;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.book.BookStatus;
import be.intecbrussel.model.book.FindType;
import be.intecbrussel.model.book.SortType;
import be.intecbrussel.model.user.User;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.repository.UserRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BookService {
    private Scanner myScanner = new Scanner(System.in);
    private BookRepository bookRepository;
    private UserRepository userRepository;
    Book book;
    User user;


    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    public void addBook() {
        System.out.print("Enter book id: ");
        int bookIDNO = myScanner.nextInt();
        myScanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = myScanner.nextLine();
        System.out.print("Enter book author: ");
        String bookAuthor = myScanner.nextLine();
        System.out.print("Enter book publish year: ");
        int bookPublishYear = myScanner.nextInt();

        Optional<Book> optionalBook = bookRepository.getBookByIDNO(bookIDNO);


        Book book = new Book(bookIDNO, bookTitle, bookAuthor, bookPublishYear);
        if (book.isValid() & optionalBook.isEmpty()) {
            bookRepository.addBook(book);
        } else {
            System.out.println("addBook failed. Invalid book information.");
        }

    }

    // method to control type of finding book
    public void findTypeControl(FindType findType) {
        switch (findType) {
            case ID: {
                System.out.println("Enter Book ID");
                int bookIDNO = myScanner.nextInt();
                Optional<Book> foundBookByBookId = findBookByBookId(bookIDNO);

                if (foundBookByBookId.isPresent()) {
                    System.out.println(foundBookByBookId.get());
                } else {
                    System.out.println("Book not found with given ID: ");
                }
                break;
            }

            case TITLE: {
                System.out.println("Enter Book Title");
                String bookTitle = myScanner.nextLine();
                List<Book> foundBookByBookTitle = findBookByBookTitle(bookTitle);

                if (!foundBookByBookTitle.isEmpty()) {
                    System.out.println("Books by " + bookTitle + ":");
                    foundBookByBookTitle.forEach(System.out::println);
                } else {
                    System.out.println("No books found for given: " + bookTitle);
                }
                break;
            }

            case AUTHOR: {
                System.out.println("Enter Book Author");
                String bookAuthor = myScanner.nextLine();
                List<Book> foundBookByBookAuthor = findBookByBookAuthor(bookAuthor);

                if (!foundBookByBookAuthor.isEmpty()) {
                    System.out.println("Books by " + bookAuthor + ":");
                    foundBookByBookAuthor.forEach(System.out::println);
                } else {
                    System.out.println("No books found for author: " + bookAuthor);
                }

            }
        }
    }

    public Optional<Book> findBookByBookId(int bookIdNO) {
        return bookRepository.getBookList().stream()
                .filter(book -> book.getBookIDNO() == bookIdNO)
                .findFirst();

    }

    public List<Book> findBookByBookTitle(String bookTitle) {

        return bookRepository.getBookList().stream()
                .filter(book -> book.getBookTitle().equalsIgnoreCase(bookTitle))
                .collect(Collectors.toList());

    }

    public List<Book> findBookByBookAuthor(String bookAuthor) {
        return bookRepository.getBookList().stream()
                .filter(book -> book.getBookAuthor().equalsIgnoreCase(bookAuthor))
                .collect(Collectors.toList());

    }


    public void borrowBook() {

        User user = new User();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your id:");
        int userId = scanner.nextInt();

        System.out.println("Enter the book ID to borrow:");
        int bookIDNO = scanner.nextInt();

        Optional<Book> optionalBook = bookRepository.getBookByIDNO(bookIDNO);
        Optional<User> optionalUser = userRepository.getUserById(userId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.getStatus() == BookStatus.AVAILABLE) {
                // Set issue date to current date
                LocalDate issueDate = LocalDate.now();
                // Calculate due date (e.g., 30 days from issue date)
                LocalDate dueDate = issueDate.plusDays(30);

                book.setStatus(BookStatus.BORROWED);
                book.setBorrowedBy(String.valueOf(optionalUser));
                book.setIssueDate(issueDate);
                book.setDueDate(dueDate);
                System.out.println("Book borrowed successfully. Due date: " + dueDate);
            } else {
                System.out.println("The book is not available for borrowing.");
            }
        } else {
            System.out.println("User or book not found.");
        }
    }

    public void issueBook() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the book you want to issue:");
        int bookIDNO = myScanner.nextInt();

        System.out.println("Enter userID whom you want to issue.");
        int userId = scanner.nextInt();

        Optional<Book> optionalBook = bookRepository.getBookByIDNO(bookIDNO);
        Optional<User> optionalUser = userRepository.getUserById(userId);

        if (optionalBook.isPresent() && optionalUser.isPresent()) {
            Book book = optionalBook.get();

            if (book.getStatus() == BookStatus.AVAILABLE) {

                LocalDate issueDate = LocalDate.now();
                LocalDate dueDate = issueDate.plusDays(30);

                book.setStatus(BookStatus.ISSUED);
                book.setBorrowedBy(String.valueOf(optionalUser));
                book.setIssueDate(LocalDate.now());
                book.setIssueDate(issueDate);
                book.setDueDate(dueDate);

                System.out.println("Book " + book.getBookTitle() + " is issued to " + optionalUser + ".");
                System.out.println("Issue Date: " + issueDate);
                System.out.println("Due Date: " + dueDate);
            } else {
                System.out.println("The book can't be issued.");
            }
        } else {
            System.out.println("User or book not found.");
        }

    }

    public void renewBook() {
       // User user = new User();
       // Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the book you want to issue:");
        int bookIDNO = myScanner.nextInt();

       // System.out.println("Enter userID whom you want to issue.");
        //int userId = scanner.nextInt();

        Optional<Book> optionalBook = bookRepository.getBookByIDNO(bookIDNO);
        //Optional<User> optionalUser = userRepository.getUserById(userId);


        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if ((book.getStatus() == BookStatus.ISSUED) || (book.getStatus() == BookStatus.BORROWED )) {
                book.setDueDate(book.getDueDate().plusDays(7)); // Extend the due date by 7 days

                System.out.println("Book renewed successfully. New due date: " + book.getDueDate());
            } else {
                System.out.println("Book cannot be renewed. It is not currently borrowed by the user.");
            }
        } else {
            System.out.println("Book not found with ID: " + bookIDNO);
        }
    }


    public void returnBookByBookIDNO() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the book you want to return:");
        int bookIDNO = myScanner.nextInt();

        myScanner.nextLine();
        System.out.println("Enter userID from whom you want to return.");
        int userId = scanner.nextInt();

        Optional<Book> bookToReturn = bookRepository.getBookByIDNO(bookIDNO);
        Optional<User> optionalUser = userRepository.getUserById(userId);

        if (bookToReturn.isPresent() && optionalUser.isPresent()) {
            Book book = bookToReturn.get();
            if (book.getStatus() == BookStatus.BORROWED && book.getBorrowedBy().equals(optionalUser))
                book.setStatus(BookStatus.AVAILABLE);

            book.setBorrowedBy(null);
            book.setIssueDate(null);
            book.setDueDate(null);
            System.out.println("Book with ID " + bookIDNO + " returned successfully.");
        } else {
            System.out.println("Book return unsuccessful. Book not found or not borrowed.");
        }
    }

      public void returnAllBooks() {
        List<Book> borrowedBooks = bookRepository.getBookList().stream()
                .filter(book -> book.getStatus() == BookStatus.BORROWED).toList();

        if (borrowedBooks.isEmpty()) {
            System.out.println("No books are currently borrowed.");
            return;
        }

        for (Book book : borrowedBooks) {
            book.setStatus(BookStatus.AVAILABLE);
            book.setBorrowedBy(null);
            book.setIssueDate(null);
            book.setDueDate(null);
        }

        System.out.println("All borrowed books returned successfully.");
    }

    public void reserveBook() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your id:");
        int userId = scanner.nextInt();

        System.out.println("Enter the book ID to reserve:");
        int bookIDNO = scanner.nextInt();

        Optional<Book> optionalBook = bookRepository.getBookByIDNO(bookIDNO);
        Optional<User> optionalUser = userRepository.getUserById(userId);


        if (optionalBook.isPresent() && optionalUser.isPresent()) {
            Book book = optionalBook.get();
            if (book.getStatus() == BookStatus.AVAILABLE) {
                book.setStatus(BookStatus.RESERVED);
                book.setReservedBy(String.valueOf(optionalUser));
                System.out.println("Book reserved successfully.");
            } else {
                System.out.println("Book cannot be reserved.");
            }
        } else {
            System.out.println("Book not found with ID: " + bookIDNO);
        }
    }


    public void browseBooks() {
        List<Book> bookList = bookRepository.getBookList();
        System.out.println("Available books:");
        bookList.forEach(System.out::println);

    }

    public void removeBook() {
        List<Book> bookList = bookRepository.getBookList();
        System.out.println("Please enter the BookIDno to remove: ");
        int bookIDNO = myScanner.nextInt();
        Optional<Book> bookToRemove = findBookByBookId(bookIDNO);
        if (bookToRemove.isPresent()) {
            bookList.remove(bookToRemove.get());
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found with ID: " + bookIDNO);
        }
    }

    public void countBooks() {
        int bookCount = bookRepository.getBookList().size();
        System.out.println("Total number of books: " + bookCount);
    }

    public void updateBookRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the BookIDno to update: ");
        int bookID = scanner.nextInt();
        Optional<Book> bookToUpdate = findBookByBookId(bookID);
        if (bookToUpdate.isPresent()) {
            Book book = bookToUpdate.get();
            System.out.print("Enter updated book title: ");
            String title = myScanner.nextLine();

            System.out.print("Enter updated book author: ");
            String author = myScanner.nextLine();

            System.out.print("Enter updated book publish year: ");
            int publishYear = myScanner.nextInt();

            book.setBookTitle(title);
            book.setBookAuthor(author);
            book.setBookPublishYear(publishYear);
            System.out.println("Book record updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

   /* public void sortTypeControl(SortType sortType) {
        switch (sortType) {
            case ID: {
                sortBooksById();
            }

            case TITLE: {
                sortBooksByTitle();
            }

            case AUTHOR: {
                sortBooksByAuthor();
            }

            case PUBLISHYEAR: {
                sortBooksByPublishYear();
            }
        }
    }*/

   /* public void sortBooksById() {
        bookRepository.getBookList().stream()
                .sorted(Comparator.comparing(Book::getBookIDNO))
                .forEach(System.out::println);
    }

    public void sortBooksByTitle() {
        bookRepository.getBookList().stream()
                .sorted(Comparator.comparing(Book::getBookTitle))
                .forEach(System.out::println);
    }

    public void sortBooksByAuthor() {
        bookRepository.getBookList().stream()
                .sorted(Comparator.comparing(Book::getBookAuthor))
                .forEach(System.out::println);
    }

    public void sortBooksByPublishYear() {
        bookRepository.getBookList().stream()
                .sorted(Comparator.comparing(Book::getBookPublishYear))
                .forEach(System.out::println);
    }*/







}



