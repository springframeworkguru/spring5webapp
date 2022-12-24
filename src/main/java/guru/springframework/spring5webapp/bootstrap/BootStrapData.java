package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author virginia = new Author( "Virginia", "Wolf");
        Book room = new Book("Un cuarto propio", "29393", "Penguin");
        virginia.getBooks().add(room);
        room.getAuthors().add(virginia);
        authorRepository.save(virginia);
        bookRepository.save(room);

        Author abbi = new Author("Abbi", "Jacobson");
        Book mightRegret = new Book( "I might regret this", "87874", "Not Penguin");
        abbi.getBooks().add(mightRegret);
        mightRegret.getAuthors().add(abbi);
        authorRepository.save(abbi);
        bookRepository.save(mightRegret);

        System.out.println("Starting bootstrap runner");
      System.out.println("Books stored:"+bookRepository.count());

    }
}
