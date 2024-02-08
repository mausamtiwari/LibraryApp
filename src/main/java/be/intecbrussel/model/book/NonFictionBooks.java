package be.intecbrussel.model.book;

public class NonFictionBooks extends Book{
    public NonFictionBooks(Integer bookIdNo , String bookTitle, String bookAuthor , int bookPublishYear, BookStatus status)
    {
        super(bookIdNo,bookTitle,bookAuthor,bookPublishYear,status);
    }
}
