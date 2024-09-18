package syksy2024.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import syksy2024.bookstore.domain.Book;
import syksy2024.bookstore.domain.BookRepository;
import syksy2024.bookstore.domain.CategoryRepository;

@Controller

public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository caterepository;

    @GetMapping("/index")
    @ResponseBody
    public String showIndex() {
        return "index";
    }

    @GetMapping({"/", "/booklist"})
    public String bookList(Model model) {
    System.out.println("Read books from database");
    model.addAttribute("books", repository.findAll());
    return "booklist";
    }

    @GetMapping("/addbook")
    public String addBook(Model model){
    model.addAttribute("book", new Book());
    model.addAttribute("categories", caterepository.findAll());
    return "addbook";
    }

    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        System.out.println("CONTROLLER: Save some the book - check validation of book: " + book);
        if (bindingResult.hasErrors()) {
            System.out.println("some validation error happened, book" + book);
            model.addAttribute("editbook", book);
            model.addAttribute("categories", caterepository.findAll());
        return "addbook";
    }
    repository.save(book);
    return "redirect:booklist";
    }

    @GetMapping("editBook/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
	model.addAttribute("editBook", repository.findById(id));
    model.addAttribute("categories", caterepository.findAll());
	return "editBook";
	}

    @PostMapping("/saveEditedBook")
	public String saveEditedBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
		System.out.println("CONTROLLER: Save some the car - check validation of book: " + book);
		if (bindingResult.hasErrors()) {
			System.out.println("some validation error happened, book: " + book);
			model.addAttribute("editBook", book);
			model.addAttribute("categories", repository.findAll());
			return "editBook";
		}
		repository.save(book);
		return "redirect:booklist";
	}

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, Model model) {
    repository.deleteById(id);
    return "redirect:/booklist";
    }
}
