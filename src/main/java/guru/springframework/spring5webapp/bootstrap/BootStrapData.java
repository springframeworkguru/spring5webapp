package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AddressRepository;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author igorg
 * @Date 17.04.2022
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    private final AddressRepository addressRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driver Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "39394595459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books - " + bookRepository.count());

        Publisher apress = new Publisher("APress");
        Address addressApress = new Address("25th street, 3 flat", "New York", "New York", "10001");
        apress.getAddress().add(addressApress);

        addressRepository.save(addressApress);
        publisherRepository.save(apress);

        Publisher oReily = new Publisher("O'Reily");
        Address addressOReily = new Address("5th street, 7 flat", "New York", "New York", "10010");
        oReily.getAddress().add(addressOReily);

        addressRepository.save(addressOReily);
        publisherRepository.save(oReily);

        System.out.println("Number of Publisher - " + publisherRepository.count());
        publisherRepository.findAll().forEach(System.out::println);
        System.out.println("Number of Address - " + addressRepository.count());
        addressRepository.findAll().forEach(System.out::println);
    }
}
