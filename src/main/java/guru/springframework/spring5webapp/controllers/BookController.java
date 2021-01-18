/*
    Author: Caleb
    Date: 1/18/21
 */
package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller // Spring MVC controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        // When Spring gets a request to the URL "/books", it is going to execute
        // the getBooks() method which provides a Model object
        model.addAttribute("books", bookRepository.findAll()); // Returns a list of books from the database

        return "books/list";
    }
}
