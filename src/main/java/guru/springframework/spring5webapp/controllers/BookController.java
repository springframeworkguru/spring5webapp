package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository; // asking Spring to inject a book repository

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        // at runtime when spring gets a request to the url /books it will
        // execute the get books method, provide that method a model object
        // for that model we are going to add an attribute called books and execute book repository
        // which will give us a list of books.
        // the model will get returned to the view layer which will have an attribute called books
        // containing a list of books, we will be able to apply that value inside the view layer
        // to apply the necessary view we will be rturning back to the client
        model.addAttribute("books", bookRepository.findAll());

        return "Books";
    }
}
