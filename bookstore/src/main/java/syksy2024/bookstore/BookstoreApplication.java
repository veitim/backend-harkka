package syksy2024.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy2024.bookstore.domain.Book;
import syksy2024.bookstore.domain.BookRepository;
import syksy2024.bookstore.domain.Category;
import syksy2024.bookstore.domain.CategoryRepository;
import syksy2024.bookstore.web.BookController;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository bookRepository, CategoryRepository cateRepository) {
		return (args) -> {
			Category category1 = new Category("Horror");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Sci-fi");
			Category category4 = new Category("Thriller");

			cateRepository.save(category1);
			cateRepository.save(category2);
			cateRepository.save(category3);
			cateRepository.save(category4);
			
			bookRepository.save(new Book(24, 1990, 123, "Doors", "Meathead", category1));
			bookRepository.save(new Book(42, 1999, 345, "Plop", "Stupido", category2));
			bookRepository.save(new Book(15, 2021, 578, "Kappa", "Reatardo", category3));
			System.out.println("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
