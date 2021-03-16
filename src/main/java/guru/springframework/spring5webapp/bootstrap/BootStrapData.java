package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Author morawski = new Author("Morawski", "Slawek");
        Book fiata = new Book("FOOTBALL INTELLIGENCE AND TACTICAL ANALYSIS", "123456");
        Publisher football_publisher = new Publisher("Football Publisher", "address", "city", "state", "null");
        publisherRepository.save(football_publisher);

        // relation book and author
        morawski.getBooks().add(fiata);
        fiata.getAuthors().add(morawski);

        fiata.setPublisher(football_publisher);
        football_publisher.addBook(fiata);

        authorRepository.save(morawski);
        bookRepository.save(fiata);
        publisherRepository.save(football_publisher);


        System.out.println("Started in BootStrapData");
        System.out.println(football_publisher.getName() + " book's: ");
        System.out.println("Number of book: " + bookRepository.count());
        System.out.println("Number of publisher: " + publisherRepository.count());
        System.out.println("Number book of publisher: " + football_publisher.getBooks().size());
        System.out.println("Number book of publisher: " + football_publisher.getBooks().toString());


    }
}
