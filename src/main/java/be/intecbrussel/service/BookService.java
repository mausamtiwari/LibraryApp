package be.intecbrussel.service;

import be.intecbrussel.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;

    }

}
