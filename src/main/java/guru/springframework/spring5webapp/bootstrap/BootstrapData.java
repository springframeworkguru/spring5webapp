package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

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

        Book book1 = new Book("Gone with the wind", UUID.randomUUID().toString());
        Author author1 = new Author("Eric", "Evans");

        Publisher publisher = new Publisher("Code street",
                12,
                null,
                "ABC123",
                "Code Town",
                "Code Country");

        publisherRepository.save(publisher);


        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Book book2 = new Book("Too much ado about nothing", UUID.randomUUID().toString());
        Author author2 = new Author("Barbara", "Higgins");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Number of saved templates -> " + bookRepository.count());
        System.out.println("Number of saved authors -> " + authorRepository.count());
        System.out.println("Number of saved publishers -> " + publisherRepository.count());
        System.out.println("Number of templates saved to a publisher -> " + publisher.getBooks().size());
        System.out.println("Details of a created publisher -> " + publisher.toString());
    }
}
