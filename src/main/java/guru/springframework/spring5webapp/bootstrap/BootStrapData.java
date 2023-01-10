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
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Ahmed", "Yamir");
        Book book1 = new Book("Spring boot", "12QS");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("Taha", "Salhi");
        Book book2 = new Book("C++", "AZ321GFF");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);



        Publisher publisger=new Publisher("Publisger 1","AddressL1","Ottawa","Ontario","K3E 6T9");
        book1.setPublisher(publisger);
        publisger.getBooks().add(book1);

        book2.setPublisher(publisger);
        publisger.getBooks().add(book2);

        publisherRepository.save(publisger);

        System.out.println("Number of book here: " + bookRepository.count());
        System.out.println("Number of author here: " + authorRepository.count());
        System.out.println("Number of publisher here: " +  publisherRepository.count());

    }
}
