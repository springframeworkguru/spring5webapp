package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	private BookRepository bookRepository;
	
	public BookController(BookRepository pBookRepository) {
		this.bookRepository = pBookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model pModel) {		
		pModel.addAttribute("books", bookRepository.findAll());
		
		return "books";
	}
}
