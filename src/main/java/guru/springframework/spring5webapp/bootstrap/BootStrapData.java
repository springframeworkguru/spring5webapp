package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AddressRepository;
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
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, AddressRepository addressRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.addressRepository = addressRepository;
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

        Address address = createAddress();
        addressRepository.save(address);

        Publisher publisher = createPublisher(saahon, address);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("saved books: " + bookRepository.count());
        System.out.println("saved authors: " + authorRepository.count());
        System.out.println("saved publishers: " + publisherRepository.count());
        System.out.println("saved addresses: " + addressRepository.count());
    }

    private static Publisher createPublisher(Author saahon, Address address) {
        Publisher publisher = new Publisher();
        publisher.setName(saahon.getFirstName());
        publisher.setAddress(address);
        return publisher;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setAddress(PUBLISHER_ADDRESS);
        address.setCity(PUBLISHER_CITY);
        address.setState(PUBLISHER_STATE);
        address.setZip(PUBLISHER_ZIP_CODE);
        return address;
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
