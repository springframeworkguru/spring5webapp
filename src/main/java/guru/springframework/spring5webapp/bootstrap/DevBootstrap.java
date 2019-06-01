package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	/**
	 * @param authorRepository
	 * @param bookRepository
	 * @param publisherRepository
	 */
	public DevBootstrap(AuthorRepository authorRepository,
			BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent pContextRefreshedEvent) {
		initData();
	}

	private void initData() {
		
	
		
		Publisher lFirstPublisher = new Publisher();
		lFirstPublisher.setName("Joyce");
		lFirstPublisher.setAddress("88 Bush avenue");
		publisherRepository.save(lFirstPublisher);
		
		Author lFirstAuthor = new Author("Eric" , "Evans");
		Book lFirstBook = new Book("Domain Driven Design", "1234", lFirstPublisher);
		lFirstAuthor.getBooks().add(lFirstBook);
		
		authorRepository.save(lFirstAuthor);
		bookRepository.save(lFirstBook);
		
		
		
		Publisher lSecondPublisher = new Publisher();
		lSecondPublisher.setName("Fred");
		lSecondPublisher.setAddress("32 East street");
		publisherRepository.save(lSecondPublisher);
		
		Author lSecondAuthor = new Author("Rod" , "Johnson");
		Book lSecondBook = new Book("J2EE Development without EJB", "1234", lSecondPublisher);
		lSecondAuthor.getBooks().add(lSecondBook);
		
		authorRepository.save(lSecondAuthor);
		bookRepository.save(lSecondBook);
		
	}
}
