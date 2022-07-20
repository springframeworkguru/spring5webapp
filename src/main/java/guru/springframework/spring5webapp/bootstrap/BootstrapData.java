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
public class BootstrapData implements CommandLineRunner {

    public final AuthorRepository authorRepository;
    public final BookRepository bookRepository;
    public final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args){

        Publisher bobco = new Publisher();

        bobco.setName("Bobco");
        bobco.setAddress("111 Main Street");
        bobco.setCity("Duluth");
        bobco.setState("MN");
        bobco.setZip("23465");

        publisherRepository.save(bobco);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author john = new Author("john", "steinbeck");
        Book tgw = new Book("The Grapes of Wrath", "1111111111111");
        john.getBooks().add(tgw);
        tgw.getAuthors().add(john);

        tgw.setPublisher(bobco);
        bobco.getBooks().add(tgw);

        authorRepository.save(john);
        bookRepository.save(tgw);

        Author frank = new Author("frank", "herbert");
        Book dune = new Book("Dune", "2222222222222");
        frank.getBooks().add(dune);
        dune.getAuthors().add(frank);

        dune.setPublisher(bobco);
        bobco.getBooks().add(dune);

        authorRepository.save(frank);
        bookRepository.save(dune);
        publisherRepository.save(bobco);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Books published: " + bobco.getBooks().size());
    }
}
