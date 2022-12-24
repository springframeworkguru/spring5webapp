package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRespository publisherRespository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRespository publisherRespository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRespository=publisherRespository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher=new Publisher("Penguin","Street 123","New York","NY","C231");
        publisherRespository.save(publisher);

        Author virginia = new Author("Virginia", "Wolf");
        Book room = new Book("Un cuarto propio", "29393");
        virginia.getBooks().add(room);
        room.getAuthors().add(virginia);
        room.setPublisher(publisher);
        publisher.getBooks().add(room);

        authorRepository.save(virginia);
        bookRepository.save(room);
        publisherRespository.save(publisher);

        Author abbi = new Author("Abbi", "Jacobson");
        Book mightRegret = new Book("I might regret this", "87874");
        abbi.getBooks().add(mightRegret);
        mightRegret.getAuthors().add(abbi);
        mightRegret.setPublisher(publisher);
        publisher.getBooks().add(mightRegret);
        authorRepository.save(abbi);
        bookRepository.save(mightRegret);
        publisherRespository.save(publisher);

        System.out.println("Starting bootstrap runner");
        System.out.println("Books stored:" + bookRepository.count());

        System.out.println("Publisher stored:" + publisherRespository.count());

        System.out.println("Publisher Number of books:" + publisher.getBooks().size());

    }
}
