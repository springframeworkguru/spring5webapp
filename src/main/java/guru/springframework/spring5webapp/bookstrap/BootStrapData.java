package guru.springframework.spring5webapp.bookstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component // Tells Spring that this is spring managed component
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
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("Newton Press");
        publisher.setCity("London");
        publisher.setState("New England");

        publisherRepository.save(publisher);
        System.out.println("Publisher count:"+publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        /*
        Under the cover Spring JPA is using Hibernate to save entities into H2 database in-memory
        * */
        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Number of Books: " + bookRepository.count());
    }
}
