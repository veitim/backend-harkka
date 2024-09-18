package syksy2024.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import syksy2024.bookstore.domain.Book;
import syksy2024.bookstore.domain.BookRepository;
import syksy2024.bookstore.domain.CategoryRepository;

@RestController
public class RestBookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository cateRepository;

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        System.out.println("fetch books from db and return to client as json");
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getOneBook(@PathVariable("id") Long bookId) {
        System.out.println("fetch one book from db and return to clies as json " + bookId);
        return bookRepository.findById(bookId);
    }

    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook) {
        System.out.println("save a new book " + newBook);
        return bookRepository.save(newBook);
    }

    @PutMapping("/book/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        System.out.println("editBook = " + editedBook);
        System.out.println("edit book, id = " + id);
        editedBook.setId(id);
        System.out.println("editBook = " + editedBook);
        return bookRepository.save(editedBook);
    }

    @DeleteMapping("/book/{id}")
    public Iterable <Book> deleteBook(@PathVariable Long id) {
        System.out.println("delete book, id = " + id);
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }

}
