package syksy2024.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy2024.bookstore.domain.Book;
import syksy2024.bookstore.domain.BookRepository;
import syksy2024.bookstore.web.BookController;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository bookRepository) {
		return (args) -> {		
			bookRepository.save(new Book(24, 1990, 123, "Doors", "Meathead"));
			bookRepository.save(new Book(42, 1999, 345, "Plop", "Stupido"));
			bookRepository.save(new Book(15, 2021, 578, "Kappa", "Reatardo"));

			System.out.println("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
				
			}

		};
	}

}
