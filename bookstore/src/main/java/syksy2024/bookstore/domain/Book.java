package syksy2024.bookstore.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private int price, publicationYear, isbn;
    @NotEmpty(message = "Book's title cannot be empty.")
    private String title;

    @NotEmpty(message = "Book's author cannot be empty.")
    private String author;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
        super();
    }

    public Book(long id, int price, int publicationYear, int isbn, String title, String author, Category category) {
        super();
        this.id = id;
        this.price = price;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public Book(int price, int publicationYear, int isbn, String title, String author, Category category) {
        super();
        this.price = price;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category !=null)
            return "Book [id=" + id + ", price=" + price + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                    + ", title=" + title + ", author=" + author + this.getCategory() + "]";
        else
            return "Book [id=" + id + ", price=" + price + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                    + ", title=" + title + ", author=" + author + "]";
    }

}
