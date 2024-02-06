package be.intecbrussel.repository;


import be.intecbrussel.model.book.*;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> bookList  = new ArrayList<>();
    {
        bookList.add(new ChildrenBooks(100, "Diary of Wimpy Kid", "Jeff Kinney" , 2023, true));
        bookList.add(new ChildrenBooks(101, "HarryPotter and the Philosphers", "J.K.Rowling" , 1997, true));
        bookList.add(new ChildrenBooks(102, "Good night Moon", "Margaret Wise Brown" , 1947, true));
        bookList.add(new FictionBooks(103, "The Great Gatsby", "F.Scott Fitzgerald" , 1925, true));
        bookList.add(new FictionBooks(104, "The Alchemist", "Paulo Coelho" , 1947, true));
        bookList.add(new FictionBooks(105, "To kill a mocking bird", "Harper Lee" , 1960, true));
        bookList.add(new NonFictionBooks(106, "In Cold Blood", "Truman Copote" , 1965, true));
        bookList.add(new NonFictionBooks(107, "A Brief History of Time", "Stephen Hawkings" , 1988, true));
        bookList.add(new NonFictionBooks(108, "Into Thin Air", "John Krakower" , 1997, true));
        bookList.add(new OtherBooks(109, "I am Malala", "Christina Lamb" , 2013, true));
        bookList.add(new OtherBooks(110, "The Happiest Man on Earth", "Eddie Jalem" , 2020, true));


    }

    public List<Book> getBookList() {
        return bookList;
    }
}
