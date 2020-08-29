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
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository; // testing.
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args)  {
        Publisher oreilly = new Publisher(1234566L, "OReilly", "1105 Main St.", "New York", "NY", 12345);
        publisherRepository.save(oreilly);

        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "1234987492792");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


//        ddd.setPublisher(oreilly);
//        oreilly.getBooks().add(ddd);
//        noEJB.setPublisher(oreilly);
//        oreilly.getBooks().add(noEJB);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
//        publisherRepository.save(oreilly);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publishers: " + oreilly + ", num books: " + oreilly.getBooks().size());
    }
}
