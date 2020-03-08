package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    //Como el controlador es un componente y contexto de spring es capaz de inyectar el repositorio
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    //Model is an ui object
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/list"; //we are returning the template list
    }
}
