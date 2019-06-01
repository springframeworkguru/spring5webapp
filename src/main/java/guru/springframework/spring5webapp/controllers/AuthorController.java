package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	private AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository pAuthorRepository) {
		this.authorRepository = pAuthorRepository;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model pModel) {
		
		pModel.addAttribute("authors", authorRepository.findAll());
		
		return "authors";
	}
}
