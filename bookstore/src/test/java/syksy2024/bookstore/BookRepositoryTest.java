package syksy2024.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import syksy2024.bookstore.domain.Book;
import syksy2024.bookstore.domain.BookRepository;
import syksy2024.bookstore.domain.Category;
import syksy2024.bookstore.domain.CategoryRepository;

@DataJpaTest
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = BookstoreApplication.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = brepository.findByTitle("Doors");

        //assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Meathead");
    }

    @Test
    public void createNewBook() {
        Category category = new Category("Horror");
        crepository.save(category);
        Book book = new Book(100, 1990, 313, "Best", "Writer", crepository.findByName("Horror").get(0));
        brepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        List<Book> books = brepository.findByTitle("Doors");
        Book book = books.get(0);
        brepository.delete(book);
        List<Book> newBooks = brepository.findByTitle("Doors");
        assertThat(newBooks).hasSize(0);
    }


}
