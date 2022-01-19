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
    public void run(String... args) throws Exception {

        Publisher sybex = new Publisher("Sybex", "Volodymirskya 1", "Moscov", "Moscov city","333" );

        publisherRepository.save(sybex);

        Author frank = new Author("Frank", "Herbert");
        Book dune = new Book("Dune", "3424233");
        frank.getBooks().add(dune);
        dune.getAuthors().add(frank);
        sybex.getBooks().add(dune);
        dune.setPublisher(sybex);

        authorRepository.save(frank);
        bookRepository.save(dune);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Design Driven Design", "324325");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(sybex);
        sybex.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(sybex);
        System.out.println("Started in Bootstrap");
        System.out.println("Num of books: " + bookRepository.count());
        System.out.println("Num of authors: " + authorRepository.count());



        System.out.println("Publishers "+publisherRepository.count());

        System.out.println("Publishers  num of books "+sybex.getBooks().size());

    }
}
