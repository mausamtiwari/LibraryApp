package be.intecbrussel.model.book;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import be.intecbrussel.repository.BookRepository;

public class Book {
    private int bookIDNO;
    private String bookTitle;
    private String bookAuthor;
    private int bookPublishYear;
    private String reservedBy;
    private String borrowedBy;
    private LocalDate dueDate;
    private LocalDate issueDate;
    private BookRepository bookRepository;
    private BookStatus status;

    public Book(int bookIdNo, String bookTitle, String bookAuthor, int bookPublishYear) {
        this.bookIDNO = bookIdNo;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishYear = bookPublishYear;
        this.status = BookStatus.AVAILABLE;

    }

    public Book(int bookIDNO, String bookTitle, String bookAuthor, int bookPublishYear, BookStatus status) {
        this.bookIDNO = bookIDNO;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishYear = bookPublishYear;
        this.status = status;
    }



    public int getBookIDNO() {
        return bookIDNO;
    }

    public void setBookIDNO(int bookIDNO) {
        this.bookIDNO = bookIDNO;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPublishYear() {
        return bookPublishYear;
    }

    public void setBookPublishYear(int bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }
    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isValid() {
        return bookIDNO > 0 && bookTitle != null && !bookTitle.isEmpty() &&
                bookAuthor != null && !bookAuthor.isEmpty() &&
                bookPublishYear > 0;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Optional<Book> getBookByIDNO(int bookIdNO) {
        return bookRepository.getBookList().stream()
                .filter(book -> book.getBookIDNO() == bookIdNO)
                .findFirst();
    }

    public List<Book> getBorrowedBooks() {
        return bookRepository.getBookList().stream()
                .filter(book -> book.getStatus() == BookStatus.BORROWED)
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "{" +
                " BookIDNO=  " + bookIDNO +
                ", bookTitle=  " + bookTitle +
                ", bookAuthor=  " + bookAuthor +
                ", BookPublishYear=  " + bookPublishYear +
                ", reservedBy= " + reservedBy  +
                ", borrowedBy= " + borrowedBy  +
                ", status= " + status +
                '}';
    }
}
