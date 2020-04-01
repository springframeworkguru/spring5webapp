package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private  BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){        //model will return the result to the View and in view we will decide how to return the data
    model.addAttribute("books",bookRepository.findAll());   //model will have an attribute books and it will contain the list of books
    return "books/list";
    }
}
