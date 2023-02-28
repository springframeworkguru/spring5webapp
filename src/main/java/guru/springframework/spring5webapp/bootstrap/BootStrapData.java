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
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);   // add ddd as one of the books that Eric has written
        ddd.getAuthors().add(eric); // add eric as author of the ddd book
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Author craig = new Author("Craig", "Walls");
        Book springInAction = new Book("Spring in Action 6th Edition", "39359322666");
        Book springBootInAction = new Book("Spring Boot in Action", "39359322766");
        Publisher manning = new Publisher("Manning", "20 Baldwin Road", "Shelter Island", "NY", 11964);
        // join publisher and book
        springInAction.setPublisher(manning);
        manning.getBooks().add(springInAction);
        // join book and author
        craig.getBooks().add(springInAction);
        springInAction.getAuthors().add(craig);
        // save
        publisherRepository.save(manning);
        authorRepository.save(craig);
        bookRepository.save(springInAction);
        System.out.println("Number of manning books: " + manning.getBooks().size());
        System.out.println("Adding Spring Boot in Action");
        // Spring boot in action
        manning.getBooks().add(springBootInAction);
        craig.getBooks().add(springBootInAction);
        springInAction.getAuthors().add(craig);
        System.out.println("Number of manning books: " + manning.getBooks().size());


        publisherRepository.save(manning);

        System.out.println(manning.getName());
    }
}
