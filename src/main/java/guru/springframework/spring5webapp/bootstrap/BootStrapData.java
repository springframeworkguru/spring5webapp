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
        Author jk = new Author("J.K", "Rowling");
        Book harryPotter = new Book("Harry Potter", "9780605039070");
        jk.getBooks().add(harryPotter);
        harryPotter.getAuthors().add(jk);

        authorRepository.save(jk);
        bookRepository.save(harryPotter);

        Author eric = new Author("Erik", "Freeman");
        Book hfdp = new Book("Head First Design Patterns", "9780596007126");
        eric.getBooks().add(hfdp);
        hfdp.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(hfdp);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books " + bookRepository.count());
    }
}
