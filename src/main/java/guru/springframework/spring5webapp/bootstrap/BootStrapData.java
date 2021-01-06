package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;



@Component
public class BootStrapData  implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository=publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author eric = new Author("Kapil","Sharma");
		Book book1 = new Book("Dan Brown","123456");
		
		eric.getBooks().add(book1);
		book1.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(book1);
		
		Author sachin = new Author("Sachin","Tendulkar");
		Book book2 = new Book("Life of Sachin","12345678");
		
		sachin.getBooks().add(book2);
		sachin.getBooks().add(book1);
		book2.getAuthors().add(sachin);
		authorRepository.save(sachin);
		bookRepository.save(book2);
		 
		// adding one publisher
		 Publisher indianPublihser = new Publisher();
		 indianPublihser.setName("Ninad");
		 indianPublihser.setCity("Aurangbad");
		 publisherRepository.save(indianPublihser);
		
		System.out.println("Started the bootstrap");
		System.out.println("No of Authors "+authorRepository.count());
		System.out.println("No of books "+bookRepository.count());
		System.out.println("No of books "+publisherRepository.count());
	}

}
