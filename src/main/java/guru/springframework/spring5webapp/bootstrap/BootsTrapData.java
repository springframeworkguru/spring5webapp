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
public class BootsTrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootsTrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Ciudad Autónoma de Buenos Aires");
        publisher.setState("Buenos Aires");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author authorExample1 = new Author("Author", "Example1");
        Book bookExample1 = new Book("Book Example1", "AFGH231");
        authorExample1.getBooks().add(bookExample1);
        bookExample1.getAuthors().add(authorExample1);

        bookExample1.setPublisher(publisher);
        publisher.getBooks().add(bookExample1);

        authorRepository.save(authorExample1);
        bookRepository.save(bookExample1);
        publisherRepository.save(publisher);

        Author authorExample2 = new Author("Author", "Example2");
        Book bookExample2 = new Book("Book Example2", "GHAF231");
        authorExample2.getBooks().add(bookExample2);
        bookExample2.getAuthors().add(authorExample2);

        bookExample2.setPublisher(publisher);
        publisher.getBooks().add(bookExample2);

        authorRepository.save(authorExample2);
        bookRepository.save(bookExample2);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
