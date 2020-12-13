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
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

		Publisher publisher = new Publisher();
		publisher.setName("Ally");
		publisher.setAddressLine("addr");
		publisher.setCity("Cainta");
		publisher.setState("asdf");
		publisher.setZip("1900");

		publisherRepository.save(publisher);
		
		Author icai = new Author("Icai","Castillo");
		Book prog = new Book("Trust the process","01152021");
		
		icai.getBooks().add(prog);
		prog.getAuthors().add(icai);
		prog.setPublisher(publisher);
		publisher.getBooks().add(prog);
		
		authorRepository.save(icai);
		bookRepository.save(prog);
		publisherRepository.save(publisher);
		
		Author olens = new Author("olens","lolens");
		Book uwu = new Book("puticat", "9857");
		
		olens.getBooks().add(uwu);
		uwu.getAuthors().add(olens);
		uwu.setPublisher(publisher);
		publisher.getBooks().add(uwu);
		
		authorRepository.save(olens);
		bookRepository.save(uwu);
		publisherRepository.save(publisher);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Publisher count:" + publisherRepository.count());
		System.out.println("Publisher number of books: " + publisher.getBooks().size());
		
	}
	
	
}
