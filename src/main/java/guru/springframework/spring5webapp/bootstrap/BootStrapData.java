package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component //Spring managed component
public class BootStrapData implements CommandLineRunner { //CommandLineRunner son instancias que spring normalmente busca para lanzar el programa


    private final AuthorRepository authorRepository; //Base de datos h2 que levanta spring data Jpa
    private final BookRepository bookRepository; //Base de datos h2 que levanta spring data Jpa
    private final PublisherRepository publisherRepository; //Base de datos h2 que levanta spring data Jpa

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain driven design", "123123");
        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher); //Primero se guarda el publisher para luego poder apuntar a el si no nos va a petar porque todavía no existe
        System.out.println("Publisher Count: " + publisherRepository.count());

        Set<Book> books = new HashSet<>();
        books.add(book);

        Set<Author> authors = new HashSet<>();
        authors.add(eric);

        eric.setBooks(books);
        book.setAuthors(authors);
        book.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2ee Development without EJB", "3939459459");

        Set<Book> rodBooks = new HashSet<>();
        books.add(noEJB);

        Set<Author> noEJBAuthors = new HashSet<>();
        authors.add(rod);

        rod.setBooks(rodBooks);
        noEJB.setAuthors(noEJBAuthors);
        noEJB.setPublisher(publisher);

        Set<Book> publisherBooks = new HashSet<>();
        publisherBooks.addAll(books);
        publisherBooks.addAll(rodBooks);

        publisher.setBooks(publisherBooks);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());

    }
}
