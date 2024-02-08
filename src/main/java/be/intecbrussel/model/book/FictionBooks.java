package be.intecbrussel.model.book;


public class FictionBooks extends Book{
    public FictionBooks(Integer bookIdNo , String bookTitle, String bookAuthor , int bookPublishYear, BookStatus status)
    {
        super(bookIdNo,bookTitle,bookAuthor,bookPublishYear,status);
    }
}

