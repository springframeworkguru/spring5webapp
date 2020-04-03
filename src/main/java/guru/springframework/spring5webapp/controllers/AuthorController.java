package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("templates/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors",authorRepository.findAll());       //this "authors" key will be referenced in View to access the value of authors
        return "authors/list";
    }
}
