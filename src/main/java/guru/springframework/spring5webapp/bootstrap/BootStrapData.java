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

    public static final String PUBLISHER_ADDRESS = "Sayram 5";
    public static final String PUBLISHER_CITY = "Tashkent";
    public static final String PUBLISHER_STATE = "Tashkent";
    public static final String PUBLISHER_ZIP_CODE = "100000";
    public static final String BOOK_NAME = "Java book";
    public static final String ISBN = "12345";
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void run(String... args) {
        Author saahon = createAuthor();
        Book book = createBook();

        saahon.getBooks().add(book);
        book.getAuthors().add(saahon);
        authorRepository.save(saahon);
        bookRepository.save(book);

        Publisher publisher = createPublisher(saahon);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("saved books: " + bookRepository.count());
        System.out.println("saved authors: " + authorRepository.count());
        System.out.println("saved publishers: " + publisherRepository.count());
    }

    private static Publisher createPublisher(Author saahon) {
        Publisher publisher = new Publisher();
        publisher.setAddressLine1(saahon.getFirstName());
        publisher.setAddressLine1(PUBLISHER_ADDRESS);
        publisher.setCity(PUBLISHER_CITY);
        publisher.setState(PUBLISHER_STATE);
        publisher.setZip(PUBLISHER_ZIP_CODE);
        return publisher;
    }
    private static Book createBook() {
        Book book = new Book();
        book.setTitle(BOOK_NAME);
        book.setIsbn(ISBN);
        return book;
    }

    private static Author createAuthor() {
        Author saahon = new Author();
        saahon.setFirstName("Saidakramov");
        saahon.setLastName("Avaz");
        return saahon;
    }
}
