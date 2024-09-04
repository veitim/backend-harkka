package syksy2024.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import syksy2024.bookstore.domain.Book;
import syksy2024.bookstore.domain.BookRepository;

@Controller
public class BookController {

@Autowired
    private BookRepository repository;

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
    return "addbook";
    }

    @PostMapping("addbook")
    public String save(Book book){
    repository.save(book);
    return "redirect:booklist";
    }

    @GetMapping("editbook/{id}")
	public String editbook(@PathVariable("id") Long id, Model model) {
	model.addAttribute("editbook", repository.findById(id));
	return "editbook";
	}

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, Model model) {
    repository.deleteById(id);
    return "redirect:/booklist";
    }
}
