package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository repo;
	
	
	public AuthorController(AuthorRepository repo) {
		this.repo = repo;
	}


	@GetMapping("/authors")
	public String getAutors(Model model) 
	{
		model.addAttribute("authors", repo.findAll());
		
		return "authors/list";
	}
	
}
