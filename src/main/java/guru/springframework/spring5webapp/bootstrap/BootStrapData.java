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
    public  void run(String... args) throws Exception{
        Author fyodor= new Author("Fyodor","Dostoevsky");
        Book CandP= new Book("Crime and Punishment", "978-93-5276-316-0");
        fyodor.getBooks().add(CandP);
        CandP.getAuthors().add(fyodor);

        authorRepository.save(fyodor);
        bookRepository.save(CandP);

        Author rod= new Author("Rod","Jhonson");
        Book noEJB= new Book("J2EE development without EJB","123456789");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books "+ bookRepository.count());

        Publisher OmBooks= new Publisher("Om Books International","A-12 Sector 64 ",
                "Noida","UttarPradesh","201301");

        CandP.setPublisher(OmBooks);
        noEJB.setPublisher(OmBooks);
        OmBooks.getBooks().add(CandP);
        OmBooks.getBooks().add(noEJB);
        publisherRepository.save(OmBooks);
        bookRepository.save(CandP);

        System.out.println("Number of Publisher "+ publisherRepository.count());
        System.out.println("Number of books"+ OmBooks.getBooks().size());
    }
}
