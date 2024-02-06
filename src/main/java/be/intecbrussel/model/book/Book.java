package be.intecbrussel.model.book;

import be.intecbrussel.model.user.Admin;
import be.intecbrussel.model.user.User;

public abstract class Book {
private Integer bookIDNO;
private String bookTitle;
private String bookAuthor;
private int bookPublishYear;
public Boolean bookInLibrary;
private User whereIsTheBook;

public Book()
{}
public Book(Integer bookIdNo , String bookTitle, String bookAuthor , int bookPublishYear, Boolean bookInLibrary)
{
    this. bookIDNO = bookIdNo;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
    this.bookPublishYear = bookPublishYear;
    this.bookInLibrary = bookInLibrary;
    this.whereIsTheBook=new Admin();
}

    public Integer getBookIDNO() {
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

    public Boolean getBookInLibrary() {
        return bookInLibrary;
    }

    public void setBookInLibrary(Boolean bookInLibrary) {
        this.bookInLibrary = bookInLibrary;
    }

    @Override
    public String toString() {
        return
                " Book Id   " + bookIDNO  +
                " Book Title  " + bookTitle  +
                " BookAuthor  " + bookAuthor  +
                " BookPublishYear  " + bookPublishYear +
                " BookInLibrary    " + bookInLibrary;
    }
}
