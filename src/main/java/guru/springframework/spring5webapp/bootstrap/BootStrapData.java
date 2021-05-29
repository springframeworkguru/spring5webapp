package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Author albertCamus = new Author("Albert", "Camus");
		Book theStranger = new Book("L'étranger", "9781587240324");

		albertCamus.getBooks().add(theStranger);
		theStranger.getAuthors().add(albertCamus);

		authorRepository.save(albertCamus);
		bookRepository.save(theStranger);

		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());

	}

}
