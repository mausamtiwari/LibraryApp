package be.intecbrussel.service;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.repository.BookRepository;

import java.util.Comparator;
import java.util.List;

public class BookService {
    private int bookId;

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;

    }
    public void addBook(Book book) throws Exception
    {

        List<Book> bookList = bookRepository.getBookList();

        if (book != null && isValidBook(book))
        {
            Book lastBookNoBeforeAdd = bookList.stream().max(Comparator.comparing(Book::getBookIDNO)).get();
            bookList.add(book);
            bookId =  lastBookNoBeforeAdd.getBookIDNO();  // get last largest Book ID no in the list
            book.setBookIDNO(bookId+1);   // increase 1 in last largest no to get unique ID of the book
            bookList.forEach(System.out::println);

        }
        else
        {
            throw new Exception("Kindly enter correct book info");
           // System.out.println("Unable to add the book. Check conditions.");
        }

    }
        private boolean isValidBook(Book book) {
        // Example: Check if essential information is not null
        return  book.getBookIDNO() != 0 &&
                book.getBookAuthor() != null &&
                book.getBookTitle()!= null && book.bookInLibrary != null && book.getBookPublishYear() > 0 ;
    }


    }




