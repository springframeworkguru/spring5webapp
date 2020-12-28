package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorControllers {

    private AuthorsRepository authorsRepository;

    public AuthorControllers(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @RequestMapping("/authors")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorsRepository.findAll());
        return "authors/list";
    }
}
