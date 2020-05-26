package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository ;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Started in Bootstrap");
		
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
		
		Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());
        
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        
       bookRepository.save(noEJB);
       bookRepository.save(ddd);
       publisherRepository.save(publisher);
       System.out.println("Publisher number of books: " + publisher.getBooks().size());
       
	}
}
