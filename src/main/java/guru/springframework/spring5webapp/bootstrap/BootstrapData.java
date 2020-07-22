package guru.springframework.spring5webapp.bootstrap;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	
	

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}





	@Override
	public void run(String... args) throws Exception {	
		Author nico = new Author("Nicolas", "Baudouin");
		Book velo = new Book ("le velo pour les pros", "1234467");
		nico.getBooks().add(velo);
		velo.getAuthors().add(nico);
		
		authorRepository.save(nico);
		bookRepository.save(velo);
		
		Author olivier = new Author("Olivier", "Dreux");
		Book vin = new Book("Devenir un as des vins sans devenir alcoolique", "45171881");
		olivier.getBooks().add(vin);
		vin.getAuthors().add(olivier);
		
		authorRepository.save(olivier);
		bookRepository.save(vin);
		
		Publisher flamma = new Publisher ("flammaron", "123 rue du saucisson", "Paris", "France", "75010");
		
		vin.setPublisher(flamma);
		flamma.getBooks().add(vin);
		velo.setPublisher(flamma);
		flamma.getBooks().add(velo);
		
		
		publisherRepository.save(flamma);
		
		
		
		System.out.println("Started with Bootstrap");
		System.out.println("Number of book register " + bookRepository.count());
		System.out.println("Number of authors register " + authorRepository.count());
		System.out.println("Number of book flamma owne " + flamma.getBooks().size());
		
		}
	

}
