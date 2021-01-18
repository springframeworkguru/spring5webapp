/*
    Author: Caleb
    Date: 1/16/21
 */
package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //This tells Spring that this is a Spring-managed component
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

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //Saves author and book to H2 Database
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "39343529");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Books: " + bookRepository.count());

        Publisher publisher = new Publisher("Caleb Publishing", "154256", "Seattle",
                "WA", "94813");

        Publisher publisher2 = new Publisher("sodfsdf Printing", "34sdpfs",
                "Chicago", "IL", "89001");

        publisherRepository.save(publisher);
        publisherRepository.save(publisher2);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        publisherRepository.save(publisher);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        publisherRepository.save(publisher);

        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
