package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
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

        Publisher publisher = new Publisher();
        publisher.setName("P1");
        publisher.setCity("C1");
        publisher.setState("S1");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Book_Title_1", "123456789");

        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        System.out.println(book.getPublisher().getName());

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        //---------------------------

        Publisher publisher2 = new Publisher();
        publisher.setName("P2");
        publisher.setCity("C2");
        publisher.setState("S2");

        publisherRepository.save(publisher2);

        Author auther1 = new Author("Eric", "Evans");
        Book book1 = new Book("Book_Title_1", "123456789");

        auther1.getBooks().add(book1);
        book1.getAuthors().add(auther1);
        book.setPublisher(publisher2);
        publisher2.getBooks().add(book1);


        authorRepository.save(auther1);
        bookRepository.save(book1);
        publisherRepository.save(publisher2);

        System.out.println("Number of books loaded: "+bookRepository.count());
        System.out.println("Number of authors loaded: "+authorRepository.count());
        System.out.println("Number of publisher loaded: "+publisherRepository.count());
    }
}
