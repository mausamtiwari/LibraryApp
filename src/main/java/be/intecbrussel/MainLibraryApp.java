package be.intecbrussel;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.book.ChildrenBooks;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.service.BookService;

public class MainLibraryApp {


    public static void main(String[] args) {
        BookService bookService = new BookService(new BookRepository());
        System.out.println("Welcome to Alexendria.");
        System.out.println();
        System.out.println("Sign in");



        // Method add book
        try
        {
            Book childrenBook = new ChildrenBooks(0, "The Lion Inside", "Rachel Bright", 2016, true);
            bookService.addBook(childrenBook);
        }
        catch (Exception e)
        {
            System.out.println("Book info can not be null");
        }







    }
}
