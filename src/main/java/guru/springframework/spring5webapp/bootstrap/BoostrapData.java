package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher roundHouse = new Publisher();
        roundHouse.setPublisherName("Round House");
        roundHouse.setAddressLine1("415 E Leslie");
        roundHouse.setCity("Salt Lake City");
        roundHouse.setState("UT");
        roundHouse.setZip("84115");

        publisherRepository.save(roundHouse);

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setPublisher(roundHouse);

        // Set bidirectional relationships
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        roundHouse.getBooks().add(ddd);

        // Save entities
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setPublisher(roundHouse);

        // Set bidirectional relationships
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        roundHouse.getBooks().add(noEJB);

        // Save entities
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
