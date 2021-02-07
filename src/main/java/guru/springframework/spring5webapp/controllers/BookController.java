package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository repo;
	
	
	
	public BookController(BookRepository repo) {
		this.repo = repo;
	}


	@GetMapping("/books")
	public String getBooks(Model model) 
	{
		model.addAttribute("books", repo.findAll());
		
		return "books/list";
	}
	
	
}
