package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository ;
	private final BookRepository bookRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain in drivers","123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Jhonson");
		Book noEJB = new Book("J2EE Development whithout EJB","3939459459");
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
	}
}
