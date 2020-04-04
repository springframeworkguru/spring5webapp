package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner
{
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception
	{
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book ("Domain driven design", "90835453");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author ron = new Author("Ron", "Jonson");
		Book noEjb = new Book("J2EE without EJB", "33563463");
		ron.getBooks().add(noEjb);
		noEjb.getAuthors().add(ron);

		authorRepository.save(ron);
		bookRepository.save(noEjb);

		System.out.println("Started in bootstrap");
		System.out.println("Number of books: "+ bookRepository.count());
	}

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository)
	{
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
}
