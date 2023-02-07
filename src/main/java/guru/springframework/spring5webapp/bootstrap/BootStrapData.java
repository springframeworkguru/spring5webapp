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

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("Started a Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: "+publisherRepository.count());

        Author eric= new Author("Eric","Evans");
        Book ddd= new Book("Domain driven design","12345");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //miután beállítottuk a Book és a PUblisher közötti sok-egy kapcsolatot, és Joincolumnot is beállítottuk
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author lewis= new Author("C.S","Lewis");
        Book sbj= new Book("Suprised by joy","12347");
        lewis.getBooks().add(sbj);
        sbj.getAuthors().add(lewis);

        sbj.setPublisher(publisher);
        publisher.getBooks().add(sbj);

// fontos a mentési sorrend ha 'publisherRepository.save(publisher);' feljebb van nem működik
        authorRepository.save(lewis);
        bookRepository.save(sbj);
        publisherRepository.save(publisher);


        System.out.println("Number of books:"+bookRepository.count());
        System.out.println("Publisher Number of books: "+publisher.getBooks().size());
    }
}
