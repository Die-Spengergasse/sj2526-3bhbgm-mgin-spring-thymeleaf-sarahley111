package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Book;
import at.spengergasse.spring_thymeleaf.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    // 1) LISTE
    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", repo.findAll());
        return "book_list";
    }

    // 2) FORMULAR (NEU)
    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "book_form";
    }

    // 3) CREATE (SPEICHERN)
    @PostMapping
    public String create(@ModelAttribute Book book) {
        repo.save(book);
        return "redirect:/books";
    }

    // 4) FORMULAR (EDIT)
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Book existing = repo.findById(id).orElseThrow();
        model.addAttribute("book", existing);
        return "book_form";
    }

    // 5) UPDATE (SPEICHERN)
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Book book) {
        Book existing = repo.findById(id).orElseThrow();
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPublishYear(book.getPublishYear());
        repo.save(existing);
        return "redirect:/books";
    }

    // 6) DELETE
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/books";
    }
}
