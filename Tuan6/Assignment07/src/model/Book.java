package model;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private int publishYear;
    private int quantity;
    private boolean isReferenceOnly;

    public Book(String bookID, String title, String author, int publishYear, int quantity, boolean isReferenceOnly) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.isReferenceOnly = isReferenceOnly;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        isReferenceOnly = referenceOnly;
    }

    public void decreaseStock() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public String toString() {
        return "Ma sach    : " + bookID
             + "\nTen sach   : " + title
             + "\nTac gia    : " + author
             + "\nNam XB     : " + publishYear
             + "\nSo luong   : " + quantity + " cuon"
             + "\nTham khao  : " + (isReferenceOnly ? "Co" : "Khong");
    }
}
