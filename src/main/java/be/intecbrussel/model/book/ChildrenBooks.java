package be.intecbrussel.model.book;


public class ChildrenBooks extends Book{
    public ChildrenBooks(Integer bookIdNo , String bookTitle, String bookAuthor , int bookPublishYear, BookStatus status)
    {
        super(bookIdNo,bookTitle,bookAuthor,bookPublishYear,status);
    }
}
