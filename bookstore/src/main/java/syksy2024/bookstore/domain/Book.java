package syksy2024.bookstore.domain;

public class Book {
    private long id;
    private int price, publicationYear, isbn;
    private String title, author;

    public Book(long id, int price, int publicationYear, int isbn, String title, String author) {
        this.id = id;
        this.price = price;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Book(int price, int publicationYear, int isbn, String title, String author) {
        this.price = price;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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

    @Override
    public String toString() {
        return "Book [id=" + id + ", price=" + price + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", title=" + title + ", author=" + author + "]";
    }
    
}
