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
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Started in Bootstrap");

		Author albertCamus = new Author("Albert", "Camus");
		Book theStranger = new Book("L'étranger", "9781587240324");
		Publisher folio = new Publisher("Folio", "5 rue Caston-Gallimard", "Paris", "France", "75328");

		authorRepository.save(albertCamus);
		bookRepository.save(theStranger);
		publisherRepository.save(folio);

		albertCamus.getBooks().add(theStranger);
		theStranger.getAuthors().add(albertCamus);

		theStranger.setPublisher(folio);
		folio.getBooks().add(theStranger);

		authorRepository.save(albertCamus);
		bookRepository.save(theStranger);
		publisherRepository.save(folio);

		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("The number of publisher is: " + publisherRepository.count());
		System.out.println("Number of book from Folio: " + folio.getBooks().size());
	}

}
