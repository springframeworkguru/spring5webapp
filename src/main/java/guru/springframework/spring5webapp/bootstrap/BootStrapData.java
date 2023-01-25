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
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) {

        Author eric = new Author("Eric", "Evans");
        Book domDriver = new Book("Domain Driver Design", "123123");
        Publisher galimard = new Publisher("Galimard",
                "23 rue pasteur",
                "La Garennes Colombes",
                "Haut de seine",
                "92");
        publisherRepository.save(galimard);


        eric.getBooks().add(domDriver);
        domDriver.getAuthors().add(eric);

        galimard.getBooks().add(domDriver);
        domDriver.setPublisher(galimard);

        authorRepository.save(eric);
        bookRepository.save(domDriver);

        System.out.println("number of books: " + bookRepository.count());
        System.out.println("number of publishers: " + publisherRepository.count());
        System.out.println("number of publishers: " + publisherRepository.count());

    }
}
