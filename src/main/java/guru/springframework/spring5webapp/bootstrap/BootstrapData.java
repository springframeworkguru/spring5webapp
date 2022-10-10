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
public class BootstrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design","4215123");
		Publisher pearson = new Publisher("Pearson", "214 Ching Street", "Kansas", "MA", 2088012L) ;
		
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		ddd.setPublisher(pearson);
		pearson.getBooks().add(ddd);
		
		Author rod = new Author("Rod","Jonson");
		Book notJb = new Book("J2EE without EJ8","1253124");
		
		
		rod.getBooks().add(notJb);
		notJb.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(notJb);
		publisherRepository.save(pearson);
		pearson.getBooks().add(notJb);
		
		
		notJb.setPublisher(pearson);
		
		System.out.println("Started in bootstrap");
		System.out.println("Number of books: "+bookRepository.count());
		System.out.println("Number of publishers: "+publisherRepository.count());
	}

}
