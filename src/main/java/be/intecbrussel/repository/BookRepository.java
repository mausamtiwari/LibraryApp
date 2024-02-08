package be.intecbrussel.repository;


import be.intecbrussel.model.book.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {

    Book book;
    static List<Book> bookList = new ArrayList<>();

    {
        bookList.add(new ChildrenBooks(100, "Diary of Wimpy Kid", "Jeff Kinney", 2023, BookStatus.AVAILABLE));
        bookList.add(new ChildrenBooks(101, "HarryPotter and the Philosphers", "J.K.Rowling", 1997, BookStatus.AVAILABLE));
        bookList.add(new ChildrenBooks(102, "Good night Moon", "Margaret Wise Brown", 1947, BookStatus.AVAILABLE));
        bookList.add(new FictionBooks(103, "The Great Gatsby", "F.Scott Fitzgerald", 1925, BookStatus.AVAILABLE));
        bookList.add(new FictionBooks(104, "The Alchemist", "Paulo Coelho", 1947, BookStatus.AVAILABLE));
        bookList.add(new FictionBooks(105, "To kill a mocking bird", "Harper Lee", 1960, BookStatus.AVAILABLE));
        bookList.add(new NonFictionBooks(106, "In Cold Blood", "Truman Copote", 1965, BookStatus.AVAILABLE));
        bookList.add(new NonFictionBooks(107, "A Brief History of Time", "Stephen Hawkings", 1988, BookStatus.AVAILABLE));
        bookList.add(new NonFictionBooks(108, "Into Thin Air", "John Krakower", 1997, BookStatus.AVAILABLE));
        bookList.add(new OtherBooks(109, "I am Malala", "Christina Lamb", 2013, BookStatus.AVAILABLE));
        bookList.add(new OtherBooks(110, "The Happiest Man on Earth", "Eddie Jalem", 2020, BookStatus.AVAILABLE));

    }


    public static List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public Optional<Book> getBookByIDNO(int bookIdNO) {
        return getBookList().stream()
                .filter(book -> book.getBookIDNO() == bookIdNO)
                .findFirst();
    }
}
