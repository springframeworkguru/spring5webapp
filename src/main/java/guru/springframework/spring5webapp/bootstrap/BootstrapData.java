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


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("started in bootstarp");
        Publisher publisher = new Publisher();
        publisher.setName("Amit Publisher house");
        publisher.setCity("Salt Lake City");
        publisher.setAddressLine1("1011 S WEST TEMPLE");
        publisher.setZip("84101");
        publisher.setState("UT");

        publisherRepository.save(publisher);
        System.out.println("publisher count :"+ publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book ddd= new Book("Domain Driven Design", "123456");
        eric.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod","Johnson");
        Book noJEB= new Book("JEE Development with out EJB", "54656322");
        rod.getBooks().add(noJEB);
        authorRepository.save(rod);
        bookRepository.save(noJEB);


        System.out.println("Number of books "+bookRepository.count());



    }
}
