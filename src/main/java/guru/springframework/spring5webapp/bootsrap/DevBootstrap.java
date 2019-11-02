package guru.springframework.spring5webapp.bootsrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Ivan D.
 * Date: 11/2/2019
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initDate() {
        Author rod = new Author("Rod", "Jhonson");
        authorRepository.save(rod);
        Publisher publisher = new Publisher("Collins","London");
        publisherRepository.save(publisher);
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        noEJB.setPublisher(publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        bookRepository.save(noEJB);

        Author eric = new Author("Eric", "Evans");
        authorRepository.save(eric);
        Publisher publisherN = new Publisher("OHenry","New York");
        publisherRepository.save(publisherN);
        Book ddd = new Book("Domain Driven Design", "1234");
        ddd.setPublisher(publisherN);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        bookRepository.save(ddd);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDate();
    }
}
