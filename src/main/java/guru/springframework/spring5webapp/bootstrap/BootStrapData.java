package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        // set up publisher java object
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setCity("New York");
        publisher.setState("NY");

        // save to db
        publisherRepository.save(publisher);

        //set up first author and book
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        // save first author and book
        authorRepository.save(eric);
        bookRepository.save(book1);

        // set up second author and book
        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        // save second author and book
        authorRepository.save(rod);
        bookRepository.save(book2);

        // show results
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
