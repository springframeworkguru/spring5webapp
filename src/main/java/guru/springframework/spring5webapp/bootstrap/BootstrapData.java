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

        Author matejAuthor = new Author();
        matejAuthor.setFirstName("Matej");
        matejAuthor.setLastName("Gace");

        Book mgBook = new Book();
        mgBook.setTitle("MG11");
        mgBook.setIsbn("123456");


        Author matejSavedAuthor = authorRepository.save(matejAuthor);
        Book mgSavedBook = bookRepository.save(mgBook);

        Author marijaAuthor = new Author();
        marijaAuthor.setFirstName("Marija");
        marijaAuthor.setLastName("Mamic");

        Book mmBook = new Book();
        mmBook.setTitle("MM");
        mmBook.setIsbn("987654");

        Author marijaSavedAuthor = authorRepository.save(marijaAuthor);
        Book mmSavedBook = bookRepository.save(mmBook);

        matejSavedAuthor.getBooks().add(mgSavedBook);
        marijaSavedAuthor.getBooks().add(mmSavedBook);
        mgSavedBook.getAuthors().add(matejSavedAuthor);
        mmSavedBook.getAuthors().add(marijaSavedAuthor);

        Publisher publisherMG = new Publisher();
        publisherMG.setPublisherName("publisherMG");
        publisherMG.setAddress("Radnicka 21");
        Publisher savedPublisher = publisherRepository.save(publisherMG);

        mmBook.setPublisher(savedPublisher);
        mgBook.setPublisher(savedPublisher);

        bookRepository.save(mgSavedBook);
        bookRepository.save(mmSavedBook);
        authorRepository.save(matejSavedAuthor);
        authorRepository.save(marijaSavedAuthor);


        System.out.println("in Bootstrap");
        System.out.println("Author count " +  +authorRepository.count());
        System.out.println("Book count " + bookRepository.count());

        System.out.println("Publisher count:  " + publisherRepository.count());
    }
}
