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
        Author author = new Author("Nihar", "Gharat");
        Book book = new Book("bookTitle", "adsasds");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        Publisher publisher = new Publisher("MyPublisher", "malad", "Mumbai", "Maha", "400097");
        publisherRepository.save(publisher);
        publisher.getBooks().add(book);
        book.setPublisher(publisher);
        System.out.println(book.getPublisher());
        System.out.println(publisher.getBooks().size());
        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);


        System.out.println(authorRepository.count());
        System.out.println(bookRepository.count());
        System.out.println(publisherRepository.count());
        System.out.println(publisher.getBooks().size());
    }
}
