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

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author("firstName1", "lastName1");
        Book b1 = new Book("title1", "isbn1");

        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        authorRepository.save(a1);
        bookRepository.save(b1);

        Author a2 = new Author("firstName2", "lastName2");
        Book b2 = new Book("title2", "isbn2");

        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);

        authorRepository.save(a2);
        bookRepository.save(b2);

        Publisher publisher = new Publisher();
        publisher.setName("My publisher");
        publisher.getBooks().add(b1);
        publisher.getBooks().add(b2);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Number of publisher " + publisherRepository.count());
    }
}
